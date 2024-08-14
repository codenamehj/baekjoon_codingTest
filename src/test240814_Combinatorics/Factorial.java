package test240814_Combinatorics;

import java.io.*;

class Factorial {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터

		int N = Integer.parseInt(br.readLine());

		bw.write(findF(N) + " ");

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}

	static int findF(int N) {
		int n = N;
		int f = 1;
		
		for (int i = 0; i < N; i++) {
			f *= n;
			n--;
		}

		return f;
	}
}