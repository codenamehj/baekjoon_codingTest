package test240809_FactorsAndMultiplesAndDecimals2_1;

import java.io.*;
import java.util.*;

class LeastCommonMultiple2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터
		StringTokenizer st; // StringTokenizer 선언

		st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		long gcd = 1; // 최대 공약수 초기화
		long a = A; // A값 저장
		long b = B; // B값 저장
		// 유클리드 호제법을 이용하여 최대 공약수 구하기
		while (true) {
			long r = a % b; // 나머지

			if (r == 0) {
				gcd = b;
				break;
			} else {
				a = b;
				b = r;
			}
		}

		long lcm = (A * B) / gcd; // 최대 공약수로 최소 공배수 구하기

		bw.write(lcm + "\n");

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}