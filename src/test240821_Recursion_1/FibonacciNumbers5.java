package test240821_Recursion_1;

import java.io.*;

class FibonacciNumbers5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터

		int N = Integer.parseInt(br.readLine());

		bw.write(fibonacci(N) + " ");

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}

	static int fibonacci(int N) {
		if (N < 2)
			return N;
		else
			return fibonacci(N - 1) + fibonacci(N - 2);
	}
}