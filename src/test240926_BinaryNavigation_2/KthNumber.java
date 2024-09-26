package test240926_BinaryNavigation_2;

import java.io.*;

class KthNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		int N = Integer.parseInt(br.readLine()); // 배열의 크기
		int k = Integer.parseInt(br.readLine()); // 구하려는 인덱스

		// B[k] = x에 대해 x 는 lo <= x <= hi 의 범위를 갖는다.
		long lo = 1;
		long hi = k;

		// 이분 탐색
		while (lo < hi) {
			long mid = (lo + hi) / 2; // 임의의 x(mid)를 lo와 hi의 중간 값으로 잡음
			long count = 0;

			for (int i = 1; i <= N; i++) {
				// 각 단별 mid 보다 작거나 같은 개수의 합을 구함
				// 이 때 각 행의 원소의 개수가 N(열 개수)을 초과하지 않는 선에서 합해주어야 함
				count += Math.min(mid / i, N);
			}

			// 임의의 x(mid)보다 작거나 같은 수의 개수(count)와 k의 값을 비교
			if (k <= count) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}

		System.out.println(lo);
	}
}