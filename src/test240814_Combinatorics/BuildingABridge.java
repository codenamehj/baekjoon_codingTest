package test240814_Combinatorics;

import java.io.*;
import java.util.*;

class BuildingABridge {

	// 동적 계획법 활용
	static int[][] dp = new int[30][30]; // 최대 입력값이 29

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			bw.write(nCr(M, N) + "\n");
		}

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}

	static int nCr(int n, int r) {
		if (dp[n][r] > 0) {
			return dp[n][r];
		}

		if (n == r || r == 0) {
			return dp[n][r] = 1;
		}

		return dp[n][r] = nCr(n - 1, r - 1) + nCr(n - 1, r); // 파스칼의 법칙
	}
}