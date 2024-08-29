package test240829_DynamicProgramming_1;

import java.io.*;
import java.util.*;

class ContinuousSum {

	static int[] arr;
	static Integer[] dp;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		int N = Integer.parseInt(br.readLine());

		arr = new int[N];
		dp = new Integer[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = arr[0];
		max = arr[0];

		contSum(N - 1);

		System.out.println(max);

	}

	static int contSum(int N) {
		// 탐색하지 않은 인덱스라면
		if (dp[N] == null) {
			dp[N] = Math.max(contSum(N - 1) + arr[N], arr[N]);

			// 해당 dp[N]과 max 중 큰 값으로 max 갱신
			max = Math.max(dp[N], max);
		}

		return dp[N];
	}
}