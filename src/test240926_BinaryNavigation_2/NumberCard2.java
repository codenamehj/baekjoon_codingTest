package test240926_BinaryNavigation_2;

import java.io.*;
import java.util.*;

class NumberCard2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 가지고 있는 카드의 수

		int[] card = new int[N];// 카드 번호를 담을 배열 생성

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) { // 배열에 가지고 있는 카드 번호 담기
			card[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(card); // 카드 번호 정렬

		int M = Integer.parseInt(br.readLine()); // 찾아야 하는 숫자의 수

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int fnum = Integer.parseInt(st.nextToken()); // 찾을 숫자 변수에 담기

			sb.append(upperBound(card, fnum) - lowerBound(card, fnum)).append(" ");
		}

		System.out.println(sb);
	}

	static int lowerBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;

		while (lo < hi) {
			int mid = (lo + hi) / 2;

			if (key <= arr[mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}

	static int upperBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;
		int mid;

		while (lo < hi) {
			mid = (lo + hi) / 2;

			if (key < arr[mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}

}
