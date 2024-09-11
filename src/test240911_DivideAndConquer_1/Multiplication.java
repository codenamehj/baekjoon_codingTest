package test240911_DivideAndConquer_1;

import java.io.*;
import java.util.*;

class Multiplication {
	static long C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());

		System.out.println(pow(A, B));
	}

	static long pow(long base, long exponent) {
		// 지수가 1일 경우 base 그대로 리턴
		if (exponent == 1) {
			return base % C;
		}

		// 지수의 절반에 해당하는 base^(exponent / 2)의 값을 구함
		long temp = pow(base, exponent / 2);

		// 지수가 홀수라면 base를 한 번 더 곱해줘야 함
		if (exponent % 2 == 1) {
			return (temp * temp % C) * base % C;
		}

		return temp * temp % C;
	}
}