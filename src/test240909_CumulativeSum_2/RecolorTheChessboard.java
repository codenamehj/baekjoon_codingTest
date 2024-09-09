package test240909_CumulativeSum_2;

import java.util.*;
import java.io.*;

class RecolorTheChessboard {
	static char[][] chess;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		chess = new char[N][M];

		int[][] black = new int[N + 1][M + 1];
		int[][] white = new int[N + 1][M + 1];

		for (int i = 0; i < N; i++) {
			chess[i] = br.readLine().toCharArray();
		}

		black = sumArr(black, 'B');
		white = sumArr(white, 'W');

		int min = K * K;
		for (int i = 0; i <= N - K; i++) {
			for (int j = 0; j <= M - K; j++) {
				int resB = black[i + K][j + K] - black[i + K][j] - black[i][j + K] + black[i][j];
				int resW = white[i + K][j + K] - white[i + K][j] - white[i][j + K] + white[i][j];
				min = Math.min(min, Math.min(resB, resW));
			}
		}
		System.out.println(min);
	}

	static int[][] sumArr(int[][] sum, char color) {
		for (int i = 1; i <= chess.length; i++) {
			for (int j = 1; j <= chess[i - 1].length; j++) {
				int val = 0;
				if ((i + j) % 2 == 0) {
					val = chess[i - 1][j - 1] == color ? 0 : 1;
				} else {
					val = chess[i - 1][j - 1] != color ? 0 : 1;
				}
				sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + val;
			}
		}
		return sum;
	}
}