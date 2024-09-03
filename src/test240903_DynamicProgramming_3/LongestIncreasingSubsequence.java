package test240903_DynamicProgramming_3;

import java.io.*;
import java.util.StringTokenizer;

class LongestIncreasingSubsequence {
	static int[] A;
	static Integer[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		int N = Integer.parseInt(br.readLine());

		A = new int[N];
		dp = new Integer[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		// 0 ~ N-1 까지 탐색
		for (int i = 0; i < N; i++) {
			LIS(i);
		}

		int max = dp[0];
		// 최댓값 찾기
		for (int i = 1; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

	static int LIS(int N) {
		// 만약 탐색하지 않던 위치의 경우
		if (dp[N] == null) {
			dp[N] = 1; // 1로 초기화

			// N 이전의 노드들을 탐색
			for (int i = N - 1; i >= 0; i--) {
				// 이전의 노드 중 A[N]의 값보다 작은 걸 발견했을 경우
				if (A[i] < A[N]) {
					dp[N] = Math.max(dp[N], LIS(i) + 1);
				}
			}
		}
		return dp[N];
	}
}