package test240911_DivideAndConquer_1;

import java.io.*;
import java.util.*;

class NumberOfPapers {
	static int[][] paper; // 종이 배열
	static int minus = 0; // -1 종이 개수
	static int zero = 0; // 0 종이 개수
	static int one = 0; // 1 종이 개수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		int N = Integer.parseInt(br.readLine()); // 종이의 크기

		paper = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cutting(0, 0, N);

		System.out.println(minus);
		System.out.println(zero);
		System.out.println(one);
	}

	static void cutting(int row, int col, int size) {

		if (numberCheck(row, col, size)) {
			if (paper[row][col] == -1) {
				minus++;
			} else if (paper[row][col] == 0) {
				zero++;
			} else {
				one++;
			}
			return;
		}

		int newSize = size / 3; // 삼등분으로 나눔

		cutting(row, col, newSize); // (0, 0)
		cutting(row, col + newSize, newSize); // (0, 1)
		cutting(row, col + 2 * newSize, newSize); // (0, 2)
		cutting(row + newSize, col, newSize); // (1, 0)
		cutting(row + newSize, col + newSize, newSize); // (1, 1)
		cutting(row + newSize, col + 2 * newSize, newSize); // (1, 2)
		cutting(row + 2 * newSize, col, newSize); // (2, 0)
		cutting(row + 2 * newSize, col + newSize, newSize); // (2, 1)
		cutting(row + 2 * newSize, col + 2 * newSize, newSize); // (2, 2)

	}

	static boolean numberCheck(int row, int col, int size) {
		// 첫 번째 숫자를 기준
		int value = paper[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				// 하나라도 다른 숫자가 있으면 false 리턴
				if (paper[i][j] != value) {
					return false;
				}
			}
		}
		// 모두 같은 숫자면 true 리턴
		return true;
	}
}