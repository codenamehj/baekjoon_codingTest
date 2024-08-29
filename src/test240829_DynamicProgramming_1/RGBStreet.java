package test240829_DynamicProgramming_1;

import java.io.*;
import java.util.*;

class RGBStreet {
	static int[][] cost;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		int N = Integer.parseInt(br.readLine());

		// Red = 0, Green = 1, Blue = 2
		cost = new int[N][3];
		dp = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}

		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];

		System.out.println(Math.min(paintCost(N - 1, 0), Math.min(paintCost(N - 1, 1), paintCost(N - 1, 2))));

	}

	static int paintCost(int N, int color) {
		// 만약 탐색하지 않은 배열이라면
		if (dp[N][color] == 0) {
			// color의 색에 따라 이전 집의 서로 다른 색을 재귀호출하여 최솟값과 현재 집의 비용을 더해서 DP에 저장한다
			if (color == 0) {
				dp[N][0] = Math.min(paintCost(N - 1, 1), paintCost(N - 1, 2)) + cost[N][0];
			} else if (color == 1) {
				dp[N][1] = Math.min(paintCost(N - 1, 0), paintCost(N - 1, 2)) + cost[N][1];
			} else {
				dp[N][2] = Math.min(paintCost(N - 1, 0), paintCost(N - 1, 1)) + cost[N][2];
			}

		}

		return dp[N][color];
	}
}