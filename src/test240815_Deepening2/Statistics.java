package test240815_Deepening2;

import java.io.*;

class Statistics {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터

		int N = Integer.parseInt(br.readLine()); // 수의 개수

		int[] arr = new int[8001]; //입력값 -4000 ~ 4000

		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int median = 5000;
		int mode = 5000;

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			sum += num;
			arr[num + 4000]++;

			if (max < num) {
				max = num;
			}
			if (min > num) {
				min = num;
			}
		}

		int count = 0;
		int mode_max = 0;

		boolean flag = false;

		for (int i = min + 4000; i <= max + 4000; i++) {
			if (arr[i] > 0) {
				// 중앙값 찾기
				if (count < (N + 1) / 2) {
					count += arr[i];
					median = i - 4000;
				}

				// 최빈값 찾기
				if (mode_max < arr[i]) {
					mode_max = arr[i];
					mode = i - 4000;
					flag = true;
				} else if (mode_max == arr[i] && flag == true) {
					mode = i - 4000;
					flag = false;
				}
			}
		}
		// 산술평균(소수점 이하 첫째 자리에서 반올림한 값을 출력)
		bw.write((int) Math.round((double) sum / N) + "\n");
		// 중앙값
		bw.write(median + "\n");
		// 최빈값(여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력)
		bw.write(mode + "\n");
		// 범위(최댓값과 최솟값의 차이)
		bw.write(max - min + "\n");

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}