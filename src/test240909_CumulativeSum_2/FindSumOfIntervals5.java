package test240909_CumulativeSum_2;

import java.io.*;
import java.util.*;

class FindSumOfIntervals5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 표의 크기
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수

		int[][] sum = new int[N + 1][N + 1]; // 누적합 배열

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken()); // x1
			int y1 = Integer.parseInt(st.nextToken()); // y1
			int x2 = Integer.parseInt(st.nextToken()); // x2
			int y2 = Integer.parseInt(st.nextToken()); // y2

			sb.append(sum[x2][y2] - sum[x2][y1 - 1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1]).append("\n");
		}

		System.out.println(sb);
	}
}