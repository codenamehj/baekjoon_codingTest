package test240924_DivideAndConquer_2;

import java.io.*;
import java.util.*;

class MatrixSquare {
	static int mod = 1000;
	static int N;
	static int[][] origin;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행렬 A(N * N)의 크기
		long B = Long.parseLong(st.nextToken()); // B 제곱

		origin = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken()) % mod;
			}
		}

		int[][] result = pow(origin, B);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(result[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);

	}

	// 행렬 제곱 분할정복 메소드
	public static int[][] pow(int[][] A, long exp) {

		// 지수가 1일 땐 A를 return한다.
		if (exp == 1L) {
			return A;
		}

		// 지수를 절반으로 분할하여 재귀호출
		int[][] ret = pow(A, exp / 2);

		// 하위 재귀에서 얻은 행렬을 제곱해준다.
		ret = multiply(ret, ret);

		// 만약 지수가 홀수라면 마지막에 A^1 (origin)을 곱해준다.
		if (exp % 2 == 1L) {
			ret = multiply(ret, origin);
		}

		return ret;
	}

	// o1과 o2 행렬을 곱해주는 메소드
	public static int[][] multiply(int[][] o1, int[][] o2) {

		int[][] ret = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {

					ret[i][j] += o1[i][k] * o2[k][j];
					ret[i][j] %= mod; // 행렬 원소 연산이 끝나면 MOD로 나머지 연산
				}
			}
		}
		return ret;
	}
}