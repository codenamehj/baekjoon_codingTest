package test240821_Recursion_1;

import java.io.*;

class MasterOfRecursion {
	static int call;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터

		int T = Integer.parseInt(br.readLine()); // 테스트 개수

		for (int i = 0; i < T; i++) {
			String S = br.readLine(); // 문자열 입력 받음.
			call = 0; // 호출 횟수 초기화
			bw.write(isPalindrome(S) + " " + call + "\n");
		}

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}

	static int isPalindrome(String S) {
		return recursion(S, 0, S.length() - 1);
	}

	static int recursion(String S, int l, int r) {
		call++; // 호출 횟수 증가
		if (l >= r)
			return 1;
		else if (S.charAt(l) != S.charAt(r))
			return 0;
		else
			return recursion(S, l + 1, r - 1);
	}
}