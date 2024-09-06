package test240906_CumulativeSum_1;

import java.io.*;
import java.util.*;

class HumanComputerInteraction {
	/*// 50점
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		StringBuilder sb = new StringBuilder();
		char[] S = br.readLine().toCharArray();
	
		int q = Integer.parseInt(br.readLine()); // 질문의 수
	
		for (int i = 0; i < q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char alpa = st.nextToken().charAt(0);
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
	
			int count = 0;
			for (int j = l; j <= r; j++) {
				if (alpa == S[j]) {
					count++;
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}*/

	// 100점
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		StringBuilder sb = new StringBuilder();

		String S = br.readLine(); // 문자열

		int q = Integer.parseInt(br.readLine()); // 질문의 수

		int[][] alpha = new int[26][S.length() + 1];

		for (int i = 0; i < S.length(); i++) {
			int sChar = S.charAt(i) - 'a';

			for (int j = 0; j < 26; j++) {
				alpha[j][i + 1] = alpha[j][i];
			}
			alpha[sChar][i + 1]++;
		}

		for (int i = 0; i < q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int findAlpha = st.nextToken().charAt(0) - 'a'; // 찾아야하는 문자
			int l = Integer.parseInt(st.nextToken()); // 시작
			int r = Integer.parseInt(st.nextToken()); // 끝

			sb.append(alpha[findAlpha][r + 1] - alpha[findAlpha][l]).append("\n");
		}
		System.out.println(sb);
	}
}