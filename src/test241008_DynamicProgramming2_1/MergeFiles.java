package test241008_DynamicProgramming2_1;

import java.io.*;
import java.util.*;

class MergeFiles {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int K = Integer.parseInt(br.readLine());

			int dp[][] = new int[K + 1][K + 1];
			int sum[] = new int[K + 1]; // 누적합 배열

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 1; i <= K; i++) {
				int file = Integer.parseInt(st.nextToken());
				sum[i] = file + sum[i - 1];
			}

			// DP 테이블 만들기
			for (int i = 1; i <= K; i++) { // 1 부터 K까지 DP 테이블 만들기
				for (int start = 1; start + i <= K; start++) {
					int end = start + i;
					dp[start][end] = Integer.MAX_VALUE;

					for (int mid = start; mid < end; mid++) { // start-mid, (mid+1)-end 두 개 묶음으로 최솟값 구하기
						dp[start][end] = Math.min(dp[start][end],
								dp[start][mid] + dp[mid + 1][end] + sum[end] - sum[start - 1]);
					}
				}
			}
			sb.append(dp[1][K]).append("\n");
		}
		System.out.println(sb);
	}
}