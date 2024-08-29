package test240829_DynamicProgramming_1;

import java.io.*;

class Tile01 {

	static int[] dp = new int[1000001]; // N이 1000000 이하이므로

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		int N = Integer.parseInt(br.readLine());

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;

		// 배열 비어있는 표시는 -1 이라고 가정하고 초기화
		for (int i = 3; i < dp.length; i++) {
			dp[i] = -1;
		}

		System.out.println(tile(N));
	}

	static int tile(int N) {
		if (dp[N] == -1) { // 해당 배열에 값이 없을 경우 재귀 호출
			dp[N] = (tile(N - 1) + tile(N - 2)) % 15746;
		}
		return dp[N];
	}
}