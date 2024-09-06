package test240906_CumulativeSum_1;

import java.io.*;
import java.util.*;

class FindSumOfIntervals4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] num = new int[N + 1]; // 누적합 배열

		num[0] = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			num[i] = num[i - 1] + Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken()); // 시작
			int e = Integer.parseInt(st.nextToken()); // 끝

			sb.append(num[e] - num[s - 1]).append("\n");
		}

		System.out.println(sb);
	}
}