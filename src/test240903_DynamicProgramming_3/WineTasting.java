package test240903_DynamicProgramming_3;

import java.io.*;

class WineTasting {
	static int[] wine;
	static Integer[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		int n = Integer.parseInt(br.readLine());

		wine = new int[n + 1];
		dp = new Integer[n + 1];

		for (int i = 1; i <= n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = 0;
		dp[1] = wine[1];

		if (n > 1) {
			dp[2] = wine[1] + wine[2];
		}

		System.out.println(tasting(n));
	}

	static int tasting(int n) {
		if (dp[n] == null) {
			dp[n] = Math.max(Math.max(tasting(n - 2), tasting(n - 3) + wine[n - 1]) + wine[n], tasting(n - 1));
		}

		return dp[n];
	}
}