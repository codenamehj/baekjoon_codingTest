package test240828_Backtracking_2;

import java.io.*;

class NQueen {
	static int N; // 체스판의 크기
	static int[] arr;
	static int count = 0; // 경우의 수

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		nQueen(0);

		System.out.println(count);
	}

	static void nQueen(int depth) {
		// 행을 다 채우면 count를 1 증가시키고 return
		if (depth == N) {
			count++;
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[depth] = i;
			// 놓을 수 있는 위치일 경우 재귀함수 호출
			if (Possibility(depth)) {
				nQueen(depth + 1);
			}
		}
	}

	// Possibility() : 해당 열에서 i 번째 행에 놓을 수 있는지를 검사하는 함수
	static boolean Possibility(int col) {
		for (int i = 0; i < col; i++) {
			// 해당 열의 행과 i 열의 행이 일치할 경우(같은 행에 존재할 경우)
			if (arr[col] == arr[i]) {
				return false;
			}
			// 대각선상(열의 차와 행의 차가 같을 경우)에 놓여있는 경우
			else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		return true;
	}
}