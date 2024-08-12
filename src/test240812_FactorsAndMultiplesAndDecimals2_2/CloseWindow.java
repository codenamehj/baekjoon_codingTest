package test240812_FactorsAndMultiplesAndDecimals2_2;

import java.io.*;

class CloseWindow {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터

		int N = Integer.parseInt(br.readLine()); // 창문의 개수와 사람의 수

		int count = 0;
		// 약수의 갯수가 홀수 개(제곱수)인 수의 창문만 열림.
		for (int i = 1; i * i <= N; i++) {
			count++;
		}

		bw.write(count + "\n");

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}