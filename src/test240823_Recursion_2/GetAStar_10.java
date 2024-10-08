package test240823_Recursion_2;

import java.io.*;

class GetAStar_10 {
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터

		int N = Integer.parseInt(br.readLine());

		arr = new char[N][N];

		star(0, 0, N, false);

		for (int i = 0; i < N; i++) {
			bw.write(arr[i]);
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}

	static void star(int x, int y, int N, boolean blank) {
		// 공백칸일 경우
		if (blank) {
			for (int i = x; i < x + N; i++) {
				for (int j = y; j < y + N; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}

		// 더 이상 쪼갤 수 없는 블록일 때
		if (N == 1) {
			arr[x][y] = '*';
			return;
		}

		int size = N / 3;
		int count = 0;
		for (int i = x; i < x + N; i += size) {
			for (int j = y; j < y + N; j += size) {
				count++;
				if (count == 5) { // 공백 칸일 경우
					star(i, j, size, true);
				} else {
					star(i, j, size, false);
				}
			}
		}
	}
}