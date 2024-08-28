package test240828_Backtracking_2;

import java.io.*;
import java.util.*;

class InsertingOperators {
	static int max = Integer.MIN_VALUE; // 최댓값
	static int min = Integer.MAX_VALUE; // 최솟값
	static int[] number; // 숫자
	static int[] operator = new int[4]; // 연산자 갯수
	static int N; // 숫자 갯수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		N = Integer.parseInt(br.readLine());
		number = new int[N];

		// 숫자 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		// 연산자 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		dfs(number[0], 1);

		System.out.println(max);
		System.out.println(min);
	}

	static void dfs(int num, int idx) {
		if (idx == N) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}

		for (int i = 0; i < 4; i++) {
			// 연산자 개수가 1개 이상인 경우
			if (operator[i] > 0) {
				// 해당 연산자를 1 감소시킨다
				operator[i]--;

				switch (i) {
				case 0:
					dfs(num + number[idx], idx + 1);
					break;
				case 1:
					dfs(num - number[idx], idx + 1);
					break;
				case 2:
					dfs(num * number[idx], idx + 1);
					break;
				case 3:
					dfs(num / number[idx], idx + 1);
					break;
				}

				// 재귀호출이 종료되면 다시 해당 연산자 개수를 복구한다.
				operator[i]++;
			}
		}
	}
}