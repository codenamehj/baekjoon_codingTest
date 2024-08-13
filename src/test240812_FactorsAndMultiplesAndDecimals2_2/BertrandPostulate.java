package test240812_FactorsAndMultiplesAndDecimals2_2;

import java.io.*;

class BertrandPostulate {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터

		while (true) {
			int N = Integer.parseInt(br.readLine());

			if (N == 0)
				break;

			// 소수를 찾을 배열 생성.
			boolean[] prime = new boolean[2 * N + 1];

			int count = 0; // 소수의 갯수 초기화

			// 에라토스테네스의 체를 이용하여 소수 구하기
			// true = 합성수, false = 소수
			for (int i = 2; i <= 2 * N; i++) {
				if (prime[i])
					continue;

				if (i > N)
					count++;

				for (int j = i + i; j <= 2 * N; j += i) {
					prime[j] = true;
				}
			}

			bw.write(count + "\n");
		}

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}