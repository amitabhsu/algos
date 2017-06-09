package com.r1.linkedlist;

import java.util.*;
/*
 * Similar to balancing BST in Method 2 above, we can use a max heap on left side to represent elements that are less 
   than effective median, and a min heap on right side to represent elements that are greater than effective median.
   After processing an incoming element, the number of elements in heaps differ utmost by 1 element. When both heaps 
   contain same number of elements, we pick average of heaps root data as effective median. When the heaps are not balanced, 
   we select effective median from the root of heap containing more elements.
 */

class MaxComparator implements Comparator {
    
    @Override
    public int compare(Object x, Object y) {
        
        return (int)y - (int)x;
    }
}

public class Median {
    
    //l_heap is max heap, which means root is greater than all the rest
	//r_heap is min heap, which means root is smallest than all the rest
	//http://www.tutorialspoint.com/data_structures_algorithms/heap_data_structure.htm
	public static int getMedian(int ip, int m, PriorityQueue l_heap, PriorityQueue r_heap) {
        
        int diff = l_heap.size() - r_heap.size();
        //System.out.println("\n\nip : " + ip);
        
        switch(diff) {
            
            case 0:
                if(ip <= m) {
                    
                    l_heap.offer(ip);
                    m = (int)l_heap.peek();
                }
                else {
                    
                    r_heap.offer(ip);
                    m = (int)r_heap.peek();
                }
                break;
                
            case 1:
                if(ip <= m) {
                    
                    r_heap.offer(l_heap.poll());
                    l_heap.offer(ip);
                }
                else {
                    r_heap.offer(ip);
                }
                m = ((int)l_heap.peek() + (int)r_heap.peek()) / 2;
                break;
            
            case -1:
                if(ip > m) {
                    
                    l_heap.offer(r_heap.poll());
                    r_heap.offer(ip);
                }
                else {
                    l_heap.offer(ip);
                }
                m = ((int)l_heap.peek() + (int)r_heap.peek()) / 2;
                break;
        }
        
        //System.out.println("l_heap : " + l_heap);
        //System.out.println("r_heap : " + r_heap);
        return m;
    }
    
    public static void printMedian(int[] arr, int n) {
        
        MaxComparator max_comparator  = new MaxComparator();
        PriorityQueue<Integer> l_heap = new PriorityQueue<Integer>(n/2, max_comparator);
        PriorityQueue<Integer> r_heap = new PriorityQueue<Integer>();
        int m = 0;
        
        for(int i = 0; i < n; i++) {
            
            m = getMedian(arr[i], m, l_heap, r_heap);
            System.out.println("Median : " + m);
        }
    }
    
    public static void main(String[] args) {
        
        int[] arr = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
        int n = arr.length;
        printMedian(arr, n);
    }
}