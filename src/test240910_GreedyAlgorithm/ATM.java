package test240910_GreedyAlgorithm;

import java.io.*;
import java.util.*;

class ATM {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		int N = Integer.parseInt(br.readLine()); // 사람의 수

		int[] P = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken()); // 돈을 인출하는데 걸리는 시간
		}

		// 시간이 짧은 순으로 정렬
		Arrays.sort(P);

		int prev = 0; // 이전까지의 대기시간 누적합
		int sum = 0; // 사람별 대기시간 총합

		for (int i = 0; i < N; i++) {
			// 이전까지의 대기시간과 현재 사람이 걸리는 시간을 더해준다.
			sum += prev + P[i];

			// 이전까지의 누적합에 현재 걸리는 시간을 더해준다.
			prev += P[i];
		}
		System.out.println(sum);
	}
}