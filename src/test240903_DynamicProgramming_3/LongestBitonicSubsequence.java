package test240903_DynamicProgramming_3;

import java.io.*;
import java.util.*;

class LongestBitonicSubsequence {
	static int[] A;
	static Integer[] r_dp;
	static Integer[] l_dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		int N = Integer.parseInt(br.readLine());

		A = new int[N];
		r_dp = new Integer[N]; // LIS dp
		l_dp = new Integer[N]; // LDS dp

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		// 0 ~ N-1 까지 탐색
		for (int i = 0; i < N; i++) {
			LIS(i);
			LDS(i);
		}

		int max = -1;
		// 최댓값 찾기
		for (int i = 0; i < N; i++) {
			max = Math.max(max, r_dp[i] + l_dp[i]);
		}
		System.out.println(max - 1);
	}

	static int LIS(int N) {
		// 만약 탐색하지 않던 위치의 경우
		if (r_dp[N] == null) {
			r_dp[N] = 1; // 1로 초기화

			// N 이전의 노드들을 탐색
			for (int i = N - 1; i >= 0; i--) {
				// 이전의 노드 중 A[N]의 값보다 작은 걸 발견했을 경우
				if (A[i] < A[N]) {
					r_dp[N] = Math.max(r_dp[N], LIS(i) + 1);
				}
			}
		}
		return r_dp[N];
	}

	static int LDS(int N) {
		// 만약 탐색하지 않던 위치의 경우
		if (l_dp[N] == null) {
			l_dp[N] = 1; // 1로 초기화

			// N 이전의 노드들을 탐색
			for (int i = N + 1; i < l_dp.length; i++) {
				// 이전의 노드 중 A[N]의 값보다 작은 걸 발견했을 경우
				if (A[i] < A[N]) {
					l_dp[N] = Math.max(l_dp[N], LDS(i) + 1);
				}
			}
		}
		return l_dp[N];
	}
}