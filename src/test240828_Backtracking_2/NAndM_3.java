package test240828_Backtracking_2;

import java.io.*;
import java.util.*;

class NAndM_3 {
	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		StringTokenizer st = new StringTokenizer(br.readLine()); // StringTokenizer 선언

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];

		dfs(0);

		System.out.println(sb);
	}

	static void dfs(int depth) {
		// 재귀 깊이가 M과 같아지면 탐색 과정에서 담았던 배열을 출력
		if (depth == M) {
			for (int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[depth] = i + 1;
			dfs(depth + 1);
		}
	}
}