package test240823_Recursion_2;

import java.io.*;

class CantorSet {
	static StringBuilder sb;
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		
		String input = "";

		// EOF 또는 입력이 공백일 떄까지 입력 받음.
		while ((input = br.readLine()) != null && !input.isEmpty()) {
			int N = Integer.parseInt(input);

			int length = (int) Math.pow(3, N);
			
			sb = new StringBuilder();
			for (int i = 0; i < length; i++) {
				sb.append("-");
			}

			cantor(0, length);

			System.out.println(sb.toString());
		}
	}

	static void cantor(int start, int len) {
		if (len == 1) {
			return;
		}
		
		int nLen = len / 3;

		// 중간 부분은 공백으로 바꾸기
		for (int i = start + nLen; i < start + 2 * nLen; i++) {
			sb.setCharAt(i, ' ');
		}

		// 앞 부분
		cantor(start, nLen);
		// 뒷 부분
		cantor(start + 2 * nLen, nLen);
	}
}