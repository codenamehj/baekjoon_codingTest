package test240910_GreedyAlgorithm;

import java.io.*;

class LostParenthesis {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		int sum = 0;
		String[] subtraction = br.readLine().split("-"); // 뺄셈을 기준으로 분리

		for (int i = 0; i < subtraction.length; i++) {
			int temp = 0;

			String[] addition = subtraction[i].split("\\+"); // 덧셈을 기준으로 분리

			for (int j = 0; j < addition.length; j++) {
				temp += Integer.parseInt(addition[j]);
			}

			if (i == 0) {
				sum = temp;
			} else {
				sum -= temp;
			}
		}

		System.out.println(sum);
	}
}