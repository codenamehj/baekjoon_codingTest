package test240911_DivideAndConquer_1;

import java.io.*;

class QuadTree {
	static int[][] video; // 영상 배열
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		int N = Integer.parseInt(br.readLine()); // 영상의 크기

		video = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < str.length(); j++) {
				video[i][j] = str.charAt(j) - '0';
			}
		}

		findQuadTree(0, 0, N);

		System.out.println(sb);
	}

	static void findQuadTree(int x, int y, int size) {

		if (isPossible(x, y, size)) {
			sb.append(video[x][y]);
			return;
		}

		int newSize = size / 2; // 절반으로 나눔

		sb.append('('); // 여는 괄호로 시작

		findQuadTree(x, y, newSize); // 왼쪽 위
		findQuadTree(x, y + newSize, newSize); // 오른쪽 위
		findQuadTree(x + newSize, y, newSize); // 왼쪽 아래
		findQuadTree(x + newSize, y + newSize, newSize); // 오른쪽 아래

		sb.append(')'); // 끝나면 닫는 괄호
	}

	static boolean isPossible(int x, int y, int size) {
		// 첫 번째 숫자를 기준
		int value = video[x][y];

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				// 하나라도 다른 숫자가 있으면 false 리턴
				if (video[i][j] != value) {
					return false;
				}
			}
		}
		// 모두 같은 숫자면 true 리턴
		return true;
	}
}