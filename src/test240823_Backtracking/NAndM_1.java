package test240823_Backtracking;

import java.io.*;
import java.util.*;

class NAndM_1 {
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		StringTokenizer st = new StringTokenizer(br.readLine()); // StringTokenizer 선언

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visit = new boolean[N];
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
			if (!visit[i]) {		// 만약 해당 노드(값)을 방문하지 않았다면
				visit[i] = true;	// 해당 노드를 방문 상태로 변경
				arr[depth] = i + 1;	// 해당 깊이를 index로 하여 i + 1 값 저장
				dfs(depth + 1);		// 다음 자식 노드 방문을 위해 depth를 1 증가시기면서 재귀 호출
				
				// 자식 노드 방문이 끝나고 돌아오면 방문 노드를 방문하지 않은 상태로 변경
				visit[i] = false;
			}
		}
	}
}