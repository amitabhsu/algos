package com.r1.testjava8;

import java.util.ArrayList;

public class RotateImage {
	public static void rotate(ArrayList<ArrayList<Integer>> a) {
		int[][] m = new int[a.size()][a.get(0).size()];
		int x = (int) Math.ceil(a.size() / 2);
		int y = (int) Math.floor(a.size() / 2);
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				int temp = m[i][j];
				m[i][j]=m[j][x-i-1];
				m[j][x-i-1]=m[x-i-1][y-j-1];
				m[x-i-1][y-j-1]=m[y-j-1][i];
				m[y-j][i]=temp;

			}
		}
	}

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();

		RotateImage.rotate(a);

	}
}