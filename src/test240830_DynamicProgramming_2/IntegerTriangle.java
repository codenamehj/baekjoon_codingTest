package test240830_DynamicProgramming_2;

import java.io.*;
import java.util.*;

class IntegerTriangle {
	static int[][] arr;
	static Integer[][] dp;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		dp = new Integer[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}

		}

		for (int i = 0; i < N; i++) {
			dp[N - 1][i] = arr[N - 1][i];
		}

		System.out.println(find(0, 0));
	}

	// depth는 깊이(행), idx는 인덱스(열)를 의미
	static int find(int depth, int idx) {
		// 만약 맨 밑(깊이)의 행에 도달하면 해당 인덱스를 반환한다.
		if (depth == N - 1)
			return dp[depth][idx];

		// 만약 아직 탐색하지 않은 위치라면 다음 행의 양쪽 열 중 최댓값을 구함
		if (dp[depth][idx] == null) {
			/*
			 * 바로 다음행의 인덱스와 그 오른쪽의 인덱스 중 큰 값 찾아 dp에 현재 인덱스의 값과 더하여 저장
			 */
			dp[depth][idx] = Math.max(find(depth + 1, idx), find(depth + 1, idx + 1)) + arr[depth][idx];
		}
		return dp[depth][idx];
	}
}