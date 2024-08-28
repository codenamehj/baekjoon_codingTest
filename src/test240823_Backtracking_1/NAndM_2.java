package test240823_Backtracking_1;

import java.io.*;
import java.util.*;

class NAndM_2 {
	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		StringTokenizer st = new StringTokenizer(br.readLine()); // StringTokenizer 선언

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];

		dfs(1, 0);

		System.out.println(sb);
	}

	static void dfs(int at, int depth) {
		// 재귀 깊이가 M과 같아지면 탐색 과정에서 담았던 배열을 출력
		if (depth == M) {
			for (int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = at; i <= N; i++) {
			arr[depth] = i; // 해당 깊이를 index로 하여 해당 위치에 i 값 저장
			dfs(i + 1, depth + 1); // 다음 자식 노드 방문을 위해 i 값과 depth를 1 증가시기면서 재귀 호출
		}
	}
}