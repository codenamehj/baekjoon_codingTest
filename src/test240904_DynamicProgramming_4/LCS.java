package test240904_DynamicProgramming_4;

import java.io.*;

class LCS {
	static char[] str1;
	static char[] str2;
	static Integer[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();

		dp = new Integer[str1.length][str2.length];

		System.out.println(find_LCS(str1.length - 1, str2.length - 1));
	}

	static int find_LCS(int x, int y) {
		// 인덱스 밖 (공집합)일 경우 0 반환
		if (x < 0 || y < 0) {
			return 0;
		}

		// 만약 탐색하지 않은 인덱스라면
		if (dp[x][y] == null) {
			dp[x][y] = 0;

			// str1의 x번째 문자와 str2의 y번째 문자가 같은지 검사
			if (str1[x] == str2[y]) {
				dp[x][y] = find_LCS(x - 1, y - 1) + 1;
			}

			// 같지 않다면 LCS(dp)[x-1][y]와 LCS(dp)[x,y-1] 중 큰 값으로 초기화
			else {
				dp[x][y] = Math.max(find_LCS(x - 1, y), find_LCS(x, y - 1));
			}
		}

		return dp[x][y];
	}
}