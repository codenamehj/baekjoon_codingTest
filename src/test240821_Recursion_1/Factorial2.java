package test240821_Recursion_1;

import java.io.*;

class Factorial2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터

		int N = Integer.parseInt(br.readLine());

		bw.write(findF(N) + " ");

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}

	static long findF(int N) {
		if (N <= 1) {
			return 1;
		} else {
			return N * findF(N - 1);
		}
	}
}