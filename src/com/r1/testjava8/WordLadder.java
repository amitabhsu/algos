package com.r1.testjava8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class WordLadder {

	public static void main(String[] args) {
		
		WordLadder ladder = new WordLadder();
		HashSet<String> dict = new HashSet<>();
		dict.add("hot");
		dict.add("dot");
		dict.add("lot");
		dict.add("dog");
		dict.add("log");
		
		ArrayList<ArrayList<String>> ladders = ladder.findLadders("hit", "cog", dict);
		for (ArrayList<String> ladder1 : ladders)
		{
			for(String word : ladder1)
			System.out.println(word);
		}
				 
				 
	}
	
	
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {  
		   ArrayList<ArrayList<String>> paths = new ArrayList<ArrayList<String>>();  
		   if (start == null || end == null || start.length() == 0) return paths;  
		   
		   // maintain a hashmap for visited words  
		   Map<String, ArrayList<Node>> visited = new HashMap<String, ArrayList<Node>>();  
		   
		   // BFS to find the minimum sequence length  
		   getMinLength(start, end, dict, visited);  
		   
		   // DFS to back trace paths from end to start  
		   buildPaths(end, start, visited, new LinkedList<String>(), paths);  
		   
		   return paths;  
		 }  
		   
		 /* Use BFS to find the minimum transformation sequences length from start to end.  
		   Also store parent nodes from previous level for each visited valid word. */  
		 private void getMinLength(String start, String end, HashSet<String> dict,  
		     Map<String, ArrayList<Node>> visited) {  
		   // maintain a queue for words, depth and previous word during BSF  
		   Queue<Node> queue = new LinkedList<Node>();  
		   queue.add(new Node(start, 1));  
		   // BFS  
		   dict.add(end);  
		   int lastLevel = 0;  
		   while (!queue.isEmpty()) {  
		     Node node = queue.poll();  
		     if (lastLevel > 0 && node.depth >= lastLevel) break;  
		     // find transformable words in next level  
		     for (int i=0; i<node.word.length(); ++i) {  
		       StringBuilder sb = new StringBuilder(node.word);  
		       char original = sb.charAt(i);  
		       for (char c='a'; c<='z'; ++c) {  
		         if (c == original) continue;  
		         sb.setCharAt(i, c);  
		         String s = sb.toString();  
		         // if hits end, mark the current depth as the last level  
		         if (s.equals(end)) {  
		           if (lastLevel == 0) lastLevel = node.depth + 1;  
		         }  
		         if (dict.contains(s) && !s.equals(start)) {  
		           ArrayList<Node> pres = visited.get(s);  
		           if (pres == null) {  
		             // enqueue unvisited word  
		             queue.add(new Node(s, node.depth+1));  
		             pres = new ArrayList<Node>();  
		             visited.put(s, pres);  
		             pres.add(node);  
		           } else if (pres.get(0).depth == node.depth) {  
		             // parent nodes should be in the same level - to avoid circle in graph  
		             pres.add(node);  
		           }  
		         }  
		       }  
		     }  
		   }  
		   return ;  
		 }  
		   
		 /* Use DFS to back trace all paths from end to start. */  
		 private void buildPaths(String s, String start, Map<String, ArrayList<Node>> visited,  
		     LinkedList<String> path, ArrayList<ArrayList<String>> paths) {  
		   if (s == null || visited == null || path == null || paths == null) return;  
		   
		   path.add(0, s);  
		   if (s.equals(start)) {  
		     ArrayList<String> p = new ArrayList<String>(path);  
		     paths.add(p);  
		   } else {  
		     ArrayList<Node> pres = visited.get(s);  
		     if (pres != null) {  
		       for (Node pre : pres) {  
		         buildPaths(pre.word, start, visited, path, paths);  
		       }  
		     }  
		   }  
		   path.remove(0);  
		 }  
		   
		 private class Node {  
		   String word;  
		   int depth;  
		   public Node(String w, int d) {  
		     word = w; depth = d;  
		   }  
		 } 

}
