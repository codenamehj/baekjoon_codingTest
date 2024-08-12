package test240809_FactorsAndMultiplesAndDecimals2_1;

import java.io.*;

class NextPrimeNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터

		int T = Integer.parseInt(br.readLine()); // 테스트 갯수

		for (int i = 0; i < T; i++) {
			long num = Long.parseLong(br.readLine());

			// 입력 받은 num이 2보다 작으면 그 다음 소수는 2
			if (num < 2) {
				bw.write(2 + "\n");
				continue;
			}

			// 입력 받은 수가 2 이상이면
			while (true) {
				boolean isPrime = true;
				for (long j = 2; j <= Math.sqrt(num); j++) {
					if (num % j == 0) {
						isPrime = false;
						break;
					}
				}

				if (isPrime) {
					bw.write(num + "\n");
					break;
				}
				num++;
			}
		}

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}