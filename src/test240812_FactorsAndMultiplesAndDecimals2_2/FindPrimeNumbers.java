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

		// 배열의 인덱스는 0부터이니 N + 1 크기의 배열 생성하여 N까지 표현할 수 있게 함.
		boolean[] prime = new boolean[N + 1]; 

		// 에라토스테네스의 체를 이용하여 소수 구하기
		// true = 합성수, false = 소수
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