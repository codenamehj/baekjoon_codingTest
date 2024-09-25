package test240925_BinaryNavigation_1;

import java.io.*;
import java.util.*;

class FindNumber {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr); // 배열 정렬

		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			// 찾는 수가 있으면 1, 없을 경우 0을 출력
			if (binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}

		System.out.println(sb);
	}

	static int binarySearch(int key) {
		int lo = 0;
		int hi = arr.length - 1;

		// lo가 hi보다 커지기 전까지 반복
		while (lo <= hi) {
			int mid = (lo + hi) / 2; // 중간 지점

			// key 값이 중간 지점의 값보다 작을 경우
			if (key < arr[mid]) {
				hi = mid - 1;
			}
			// key 값이 중간 지점의 값보다 클 경우
			else if (key > arr[mid]) {
				lo = mid + 1;
			}
			// key 값과 중간 지점의 값이 같을 경우
			else {
				return mid;
			}
		}
		// 찾는 값이 없을 경우
		return -1;
	}
}