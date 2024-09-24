package test240924_DivideAndConquer_2;

import java.io.*;

class FibonacciNumbers_6 {
	static int mod = 1000000007;
	static long[][] origin = { { 1, 1 }, { 1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		long[][] A = { { 1, 1 }, { 1, 0 } };

		long N = Long.parseLong(br.readLine());

		System.out.println(pow(A, N - 1)[0][0]);
	}

	// 행렬 제곱 분할정복 메소드
	public static long[][] pow(long[][] A, long exp) {

		// 지수가 1 또는 0일 땐 A를 return
		if (exp == 1 || exp == 0) {
			return A;
		}

		// 지수를 절반으로 분할하여 재귀호출
		long[][] ret = pow(A, exp / 2);

		// 하위 재귀에서 얻은 행렬을 제곱해준다.
		ret = multiply(ret, ret);

		// 만약 지수가 홀수라면 마지막에 A^1 (origin)을 곱해줌
		if (exp % 2 == 1L) {
			ret = multiply(ret, origin);
		}

		return ret;
	}

	// o1과 o2 행렬을 곱해주는 메소드
	public static long[][] multiply(long[][] o1, long[][] o2) {
		long[][] ret = new long[2][2];

		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					ret[i][j] += o1[i][k] * o2[k][j];
					ret[i][j] %= mod;
				}
			}
		}

		return ret;
	}
}