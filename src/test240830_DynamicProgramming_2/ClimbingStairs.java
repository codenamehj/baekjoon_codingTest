package test240830_DynamicProgramming_2;

import java.io.*;

class ClimbingStairs {
	static int[] arr;
	static Integer[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		int N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];
		dp = new Integer[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// 재귀 dp는 int[] 배열이 아닌 Integer[] 객체 배열
		dp[0] = arr[0];
		dp[1] = arr[1];

		// N 이 1이 입력될 수도 있기 때문에 예외 처리
		if (N >= 2) {
			dp[2] = arr[1] + arr[2];
		}

		System.out.println(stair(N));
	}

	static int stair(int N) {
		if (dp[N] == null) {
			dp[N] = Math.max(stair(N - 2), stair(N - 3) + arr[N - 1]) + arr[N];
		}

		return dp[N];
	}
}