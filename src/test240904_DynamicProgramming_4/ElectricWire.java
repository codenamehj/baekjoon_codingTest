package test240904_DynamicProgramming_4;

import java.io.*;
import java.util.*;

class ElectricWire {
	static int[][] wire;
	static Integer[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		int N = Integer.parseInt(br.readLine()); // 전깃줄의 갯수

		wire = new int[N][2];
		dp = new Integer[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			wire[i][0] = Integer.parseInt(st.nextToken());
			wire[i][1] = Integer.parseInt(st.nextToken());
		}

		// 첫 번째 원소(A 전봇대)를 기준으로 오름차순으로 정렬
		/*
		 * Arrays.sort(wire, new Comparator<int[]>() {
		 * 
		 * @Override public int compare(int[] o1, int[] o2) { return o1[0] - o2[0]; }
		 * });
		 */

		// 람다식으로 오름차순 정렬
		Arrays.sort(wire, (o1, o2) -> {
			return o1[0] - o2[0];
		});

		int max = 0;

		// i 번째 A 전봇대를 기준으로 연결 가능한 갯수 탐색 및 최댓값 찾기
		for (int i = 0; i < N; i++) {
			max = Math.max(max, ewire(i));
		}

		// 제거할 전선의 수 = 전선 개수 - 최댓값
		System.out.println(N - max);
	}

	static int ewire(int N) {
		// 탐색하지 않았던 위치라면
		if (dp[N] == null) {

			dp[N] = 1; // 최솟값 1로 초기화

			// A의 N번째와 이후의 전봇대들 비교
			for (int i = N + 1; i < dp.length; i++) {
				// A전봇대의 N번째 전선이 연결되어있는 B전봇대보다 A의 i번째 전봇대의 전선이 이어진 B전봇대가 뒤에 있을 경우 전선을 설치할 수 있음
				if (wire[N][1] < wire[i][1]) {
					// 연결 가능한 전선의 경우의 수 중 큰 값을 dp에 저장한다.
					dp[N] = Math.max(dp[N], ewire(i) + 1);
				}
			}
		}
		return dp[N];
	}
}