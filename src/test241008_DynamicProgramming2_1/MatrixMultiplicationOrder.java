package test241008_DynamicProgramming2_1;

import java.io.*;
import java.util.*;

class MatrixMultiplicationOrder {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 행렬의 개수

		int[][] dp = new int[N][N];
		int[][] matrix = new int[N][2]; // 행렬 크기 배열

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			matrix[i][0] = Integer.parseInt(st.nextToken());
			matrix[i][1] = Integer.parseInt(st.nextToken());
		}

		// DP 테이블 만들기
		// i : 구간 간격, j : 구간 시작점, k : 중간 지점
		for (int i = 1; i < N; i++) {
			for (int j = 0; j + i < N; j++) {
				dp[j][j + i] = Integer.MAX_VALUE;
				for (int k = j; k < j + i; k++)
					dp[j][j + i] = Math.min(dp[j][j + i],
							dp[j][k] + dp[k + 1][j + i] + matrix[j][0] * matrix[k][1] * matrix[j + i][1]);
			}
		}
		System.out.println(dp[0][N - 1]);
	}
}