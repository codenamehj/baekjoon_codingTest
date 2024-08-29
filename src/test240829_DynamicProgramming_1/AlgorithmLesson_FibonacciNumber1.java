package test240829_DynamicProgramming_1;

import java.io.*;

class AlgorithmLesson_FibonacciNumber1 {
	static int fibCnt, fibonacciCnt; // 실행 횟수

	static int[] f; // 동적 프로그래밍에서 사용하는 의사코드

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		int n = Integer.parseInt(br.readLine());
		f = new int[n];

		fibCnt = 0;
		fibonacciCnt = 0;

		fib(n);
		fibonacci(n);

		System.out.println(fibCnt + " " + fibonacciCnt);
	}

	static int fib(int n) {
		if (n == 1 || n == 2) {
			fibCnt++; // 1이 몇번 더해졌는지 구하면 되기 떄문에 if문 안에
			return 1;
		} else
			return (fib(n - 1) + fib(n - 2));
	}

	static int fibonacci(int n) {
		f[0] = 1;
		f[1] = 1;

		for (int i = 2; i < n; i++) {
			// for문의 반복 횟수가 속도를 결정
			fibonacciCnt++;
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n - 1]; // 배열은 0부터 시작하므로
	}
}