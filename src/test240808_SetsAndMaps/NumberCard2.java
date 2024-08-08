package test240808_SetsAndMaps;

import java.io.*;
import java.util.*;

class NumberCard2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터
		StringTokenizer st; // StringTokenizer 선언

		int N = Integer.parseInt(br.readLine()); // 가지고 있는 카드의 수

		int[] card = new int[N];// 카드 번호를 담을 배열 생성

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) { // 배열에 가지고 있는 카드 번호 담기
			card[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(card); // 카드 번호 정렬

		int M = Integer.parseInt(br.readLine()); // 찾아야하는 숫자의 수

		int[] result = new int[M]; // 찾을 숫자 배열 생성

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int fnum = Integer.parseInt(st.nextToken()); // 찾을 숫자 변수에 담기

			result[i] = upperBound(card, fnum) - lowerBound(card, fnum);
		}

		for (int i : result) {
			bw.write(i + " ");
		}

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}

	static int lowerBound(int[] arr, int key) {
		int low = 0;
		int high = arr.length;
		int mid;

		while (low < high) {
			mid = (low + high) / 2;

			if (key <= arr[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	static int upperBound(int[] arr, int key) {
		int low = 0;
		int high = arr.length;
		int mid;

		while (low < high) {
			mid = (low + high) / 2;

			if (key < arr[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

}
