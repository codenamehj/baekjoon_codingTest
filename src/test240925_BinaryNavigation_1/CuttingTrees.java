package test240925_BinaryNavigation_1;

import java.io.*;
import java.util.*;

class CuttingTrees {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 나무의 수
		int M = Integer.parseInt(st.nextToken()); // 가져가려고 하는 나무의 길이

		int[] arr = new int[N]; // 나무의 높이 배열

		int max = 0; // 최대 나무 높이
		int min = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			// 나무의 최대 높이 구하기
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		// 이분 탐색 시작
		while (min < max) {
			int mid = (min + max) / 2;
			long sum = 0;

			for (int height : arr) {
				// 자르는 높이보다 큰 나무들만 잘려진 길이 합산
				if (height - mid > 0) {
					sum += (height - mid);
				}
			}

			// 자른 나무의 길이의 합이 M보다 작으면 자르는 높이를 낮취야하고, 그렇지않다면 자르는 높이를 높여야 함
			if (sum < M) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}

		System.out.println(min - 1);
	}
}