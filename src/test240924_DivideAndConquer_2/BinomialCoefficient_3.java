package test240924_DivideAndConquer_2;

import java.io.*;
import java.util.StringTokenizer;

class BinomialCoefficient_3 {
	static long P = 1000000007; // 소수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());

		// 분자 N!
		long numer = factorial(N);

		// 분모 (K! * (N - K)!) mod P
		long denom = factorial(K) * factorial(N - K) % P;

		// N! * 분모의 역원((N! * (N - K)!))
		System.out.println(numer * pow(denom, P - 2) % P);
	}

	static long factorial(long N) {
		long fac = 1L;

		while (N > 1) {
			fac = (fac * N) % P;
			N--;
		}
		return fac;
	}

	static long pow(long base, long exponent) {
		// 지수가 1일 경우 base^1 이므로 base % P를 리턴
		if (exponent == 1) {
			return base % P;
		}

		// 지수이 절반에 해당하는 base^(exponent / 2)을 구함
		long temp = pow(base, exponent / 2);

		// 현재 지수가 홀수 였다면 
		// base^(exponent / 2) * base^(exponent / 2) * base 이므로 
		// base를 한 번 더 곱해 줌
		if (exponent % 2 == 1) {
			return (temp * temp % P) * base % P;
		}
		return temp * temp % P;
	}
}