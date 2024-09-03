package test240903_DynamicProgramming_3;

import java.io.*;

class EasyStairs {
	static Long[][] dp;
	static int N;
	static final long MOD = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		int N = Integer.parseInt(br.readLine());
		dp = new Long[N + 1][10];

		// 첫번째 자릿수는 1로 초기화
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1L;
		}

		long result = 0;

		// 마지막 자릿수인 1~9까지의 경우의 수를 모두 더해준다.
		for (int i = 1; i < 10; i++) {
			result += stair(N, i);
		}

		System.out.println(result % MOD);
	}

	/*
	 * digit는 자릿수, val은 자릿값을 의미
	 * 첫째 자리수는 각 val이 끝이기 때문에 경우의 수는 1밖에 없다.
	 * 즉, dp[1]의 각 자릿값은 1로 초기화 되어있어야한다.
	 */
	static long stair(int digit, int val) {
		// 첫째 자리수에 도착한다면 더이상 탐색할 필요 없음
		if (digit == 1) {
			return dp[digit][val];
		}

		// 해당 자리수의 val 값에 대해 탐색하지 않았을 경우
		if (dp[digit][val] == null) {
			// val이 0일경우 이전 자리는 1밖에 못옴
			if (val == 0) {
				dp[digit][val] = stair(digit - 1, 1);
			}
			// val이 9일경우 이전은 8밖에 못옴
			else if (val == 9) {
				dp[digit][val] = stair(digit - 1, 8);
			}
			// 그 외의 경우는 val - 1과 val + 1 값의 경우의 수를 합한 경우의 수가 됨
			else {
				dp[digit][val] = stair(digit - 1, val - 1) + stair(digit - 1, val + 1);
			}
		}
		return dp[digit][val] % MOD;
	}
}