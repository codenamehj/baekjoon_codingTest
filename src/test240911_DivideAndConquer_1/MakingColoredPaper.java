package test240911_DivideAndConquer_1;

import java.io.*;
import java.util.*;

class MakingColoredPaper {
	static int white = 0; // 흰 종이 수
	static int blue = 0; // 파란 종이 수
	static int[][] paper; // 전체 종이 색 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		int N = Integer.parseInt(br.readLine()); // 전체 종이의 한 변의 길이

		paper = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cutting(0, 0, N);

		System.out.println(white);
		System.out.println(blue);
	}

	static void cutting(int row, int col, int size) {
		if (colorCheck(row, col, size)) {
			if (paper[row][col] == 0) { // 색이 0이면 흰색 종이 수 증가
				white++;
			} else { // 0이 아닐 경우 파란색 종이 수 증가
				blue++;
			}
			return;
		}

		int newSize = size / 2; // 절반으로 자름

		cutting(row, col, newSize); // 2사분면
		cutting(row, col + newSize, newSize); // 1사분면
		cutting(row + newSize, col, newSize); // 3사분면
		cutting(row + newSize, col + newSize, newSize); // 4사분면
	}

	static boolean colorCheck(int row, int col, int size) {
		// 첫 번째 색을 기준
		int color = paper[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				// 하나라도 다른 컬러가 있으면 false 리턴
				if (paper[i][j] != color) {
					return false;
				}
			}
		}
		// 모두 같은 색이면 true 리턴
		return true;
	}
}