package test240924_DivideAndConquer_2;

import java.io.*;
import java.util.*;

class MatrixMultiplication {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		// 행렬 A(N * M)의 크기
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] A = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		// 행렬 B(M * K)의 크기
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] B = new int[M][K];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 행렬 계산 및 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				int sum = 0;
				for (int k = 0; k < M; k++) {
					sum += A[i][k] * B[k][j];
				}
				sb.append(sum).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}