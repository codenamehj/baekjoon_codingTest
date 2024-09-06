package test240906_CumulativeSum_1;

import java.io.*;
import java.util.*;

class Sequence {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] temperat = new int[N]; // 온도 배열

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			temperat[i] = Integer.parseInt(st.nextToken());
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N + 1 - K; i++) {
			int sum = 0;
			for (int j = i; j < i + K; j++) {
				sum += temperat[j];
			}
			if (max < sum) {
				max = sum;
			}
		}

		System.out.println(max);
	}
}