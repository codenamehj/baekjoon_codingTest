package test240906_CumulativeSum_1;

import java.io.*;
import java.util.*;

class RemainderSum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] S = new long[N + 1]; // 누적합 배열
		long[] count = new long[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			S[i] = (S[i - 1] + Integer.parseInt(st.nextToken())) % M;
			count[(int) S[i]]++;
		}

		long result = count[0];
		for (int i = 0; i < M; i++) {
			if (count[i] > 1) {
				result += (count[i] * (count[i] - 1) / 2);
			}
		}
		System.out.println(result);
	}
}