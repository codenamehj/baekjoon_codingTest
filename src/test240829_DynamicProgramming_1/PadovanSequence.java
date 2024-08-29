package test240829_DynamicProgramming_1;

import java.io.*;

class PadovanSequence {

	static long[] seq = new long[101]; // N이 100 이하이므로

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		int T = Integer.parseInt(br.readLine());

		seq[0] = 0;
		seq[1] = 1;
		seq[2] = 1;
		seq[3] = 1;

		// 배열 비어있는 표시는 -1 이라고 가정하고 초기화
		for (int i = 4; i < seq.length; i++) {
			seq[i] = -1;
		}

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(P(N));
		}

	}

	static long P(int N) {
		if (seq[N] == -1) { // 해당 배열에 값이 없을 경우 재귀 호출
			seq[N] = P(N - 2) + P(N - 3);
		}
		return seq[N];
	}
}