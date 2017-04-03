package com.fzj.leetcode;

public class RotateImage {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		int[][] temp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp[j][n - 1 - i] = matrix[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = temp[i][j];
			}
		}
	}

	/**
	 * 做两次翻转，先沿右上-左下的对角线翻转，再沿水平中线上下翻转
	 * 
	 * @param matrix
	 */
	public void rotate2(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				matrix[i][j] = matrix[n-1-j][n - 1 - i] ^ matrix[i][j] ^ (matrix[n-1-j][n - 1 - i] = matrix[i][j]);
			}
		}
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = matrix[n-1-i][j] ^ matrix[i][j] ^ (matrix[n-1-i][j] = matrix[i][j]);
			}
		}
	}

	public void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
				if (j < matrix[i].length - 1)
					System.out.print(" ");
				else
					System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		RotateImage rotateImage = new RotateImage();
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		rotateImage.rotate2(matrix);
		rotateImage.print(matrix);
	}
}
