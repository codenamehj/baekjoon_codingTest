package test240812_FactorsAndMultiplesAndDecimals2_2;

import java.io.*;
import java.util.*;

class FindPrimeNumbers {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터
		StringTokenizer st; // StringTokenizer 선언

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		boolean[] prime = new boolean[N + 1];

		// 다시 이해 하기!
		for (int i = 2; i <= N; i++) {
			if (prime[i])
				continue;

			if (i >= M)
				bw.write(i + "\n");

			for (int j = i + i; j <= N; j += i) {
				prime[j] = true;
			}
		}

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}