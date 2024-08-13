package test240812_FactorsAndMultiplesAndDecimals2_2;

import java.io.*;

class GoldbachPartition {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터

		int T = Integer.parseInt(br.readLine()); // 테스트 갯수

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			// 소수를 찾을 배열 생성.
			boolean[] prime = new boolean[N + 1];
			// 소수 배열을 찾는 함수를 호출하여 만든 배열에 담아 줌.
			prime = findPrime(prime, N);

			// 두 소수의 합이 N이 되는 경우의 수 체크
			int count = 0;

			for (int j = 0; j <= N / 2; j++) {
				if (!prime[j] && !prime[N - j]) {
					count++;
				}
			}
			bw.write(count + "\n"); // count 출력ㅁ

		}

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}

	// 에라토스테네스의 체를 이용하여 소수 구하기
	// true = 소수가 아닌 수, false = 소수
	public static boolean[] findPrime(boolean[] p, int n) {
		p[0] = true;
		p[1] = true;

		for (int i = 2; i < Math.sqrt(n); i++) {
			if (!p[i]) {
				for (int j = i * i; j <= n; j += i) {
					p[j] = true;
				}
			}
		}

		return p;
	}
}