package test240904_DynamicProgramming_4;

import java.io.*;
import java.util.*;

class AnOrdinaryKnapsack {
	static int[] W; // 물건의 무게
	static int[] V; // 물건의 가치
	static Integer[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 물품의 수
		int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

		W = new int[N];
		V = new int[N];

		dp = new Integer[N][K + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(knapsack(N - 1, K)); // 가치합의 최댓값 출력
	}

	static int knapsack(int i, int k) {
		// i가 0 미만, 즉 범위 밖이 된다면
		if (i < 0)
			return 0;

		// 탐색하지 않은 위치라면
		if (dp[i][k] == null) {

			// 현재 물건(i)을 추가로 못담는 경우 (이전 i 값 탐색)
			if (W[i] > k) {
				dp[i][k] = knapsack(i - 1, k);
			}
			// 현재 물건(i)을 담을 수 있는 경우
			else if (W[i] <= k) {
				// 이전 i 값과 이전 i 값에 대한 k - W[i]의 값 + 현재 가치(V[i]) 중 큰 값을 저장
				dp[i][k] = Math.max(knapsack(i - 1, k), knapsack(i - 1, k - W[i]) + V[i]);
			}
		}
		return dp[i][k];
	}
}