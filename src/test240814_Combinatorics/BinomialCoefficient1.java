package test240814_Combinatorics;

import java.io.*;
import java.util.*;

class BinomialCoefficient1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		bw.write(nCr(N, K) + " ");

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}

	static int nCr(int n, int r) {
		if (n == r || r == 0) {
			return 1;
		}

		return nCr(n - 1, r - 1) + nCr(n - 1, r); // 파스칼의 법칙
	}
}