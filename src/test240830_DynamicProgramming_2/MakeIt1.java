package test240830_DynamicProgramming_2;

import java.io.*;

class MakeIt1 {
	static Integer[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		int N = Integer.parseInt(br.readLine());

		dp = new Integer[N + 1];
		dp[0] = dp[1] = 0;

		System.out.println(make1(N));
	}

	static int make1(int N) {
		// 탐색하지 않았던 N일 경우
		if (dp[N] == null) {
			// N이 6으로 나눠질 경우
			if (N % 6 == 0) {
				dp[N] = Math.min(make1(N - 1), Math.min(make1(N / 3), make1(N / 2))) + 1;
			}
			// N이 3으로만 나눠지는 경우
			else if (N % 3 == 0) {
				dp[N] = Math.min(make1(N / 3), make1(N - 1)) + 1;
			}
			// N이 2로만 나눠지는 경우
			else if (N % 2 == 0) {
				dp[N] = Math.min(make1(N / 2), make1(N - 1)) + 1;
			}
			// N이 2와 3으로 나누어지지 않는 경우
			else {
				dp[N] = make1(N - 1) + 1;
			}
		}
		return dp[N];
	}
}