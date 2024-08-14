package test240814_Combinatorics;

import java.io.*;

class GreenTower {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터

		int N = Integer.parseInt(br.readLine()); // 녹색거탑의 높이

		int caseNum = 1;
		for (int i = 0; i < N; i++) {
			caseNum *= 2;
		}

		bw.write(caseNum + " ");

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}