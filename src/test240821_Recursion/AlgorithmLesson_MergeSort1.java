package test240821_Recursion;

import java.io.*;
import java.util.*;

class AlgorithmLesson_MergeSort1 {
	int[] A;
	static int[] tmp; // 정렬 후 저장하는 배열
	static int K; // 저장 횟수
	static int cnt = 0; // 저장 횟수 누적 저장
	static int result = -1; // 결과(실패 시 -1)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // A 배열의 크기
		K = Integer.parseInt(st.nextToken()); // 저장 횟수

		int[] A = new int[N]; // A 배열
		tmp = new int[N]; // 오름차순 정렬하여 저장할 배열 초기화

		st = new StringTokenizer(br.readLine());
		// A 배열 요소 입력 받기
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		merge_sort(A, 0, N - 1);

		bw.write(result + "\n");

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}

	// 오름차순 정렬
	static void merge_sort(int[] A, int p, int r) {
		if (cnt > K)
			return;
		if (p < r) {
			int q = (p + r) / 2; // q는 p, r의 중간 지점
			merge_sort(A, p, q); // 전반부 정렬
			merge_sort(A, q + 1, r); // 후반부 정렬
			merge(A, p, q, r); // 병합
		}
	}

	// 이미 정렬된 전반부 배열과 후반부 배열을 병합
	static void merge(int[] A, int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int t = 0;

		while (i <= q && j <= r) {
			if (A[i] <= A[j]) {
				tmp[t++] = A[i++];
			} else {
				tmp[t++] = A[j++];
			}
		}

		while (i <= q) { // 왼쪽 배열 부분이 남은 경우
			tmp[t++] = A[i++];
		}

		while (j <= r) { // 오른쪽 배열 부분이 남은 경우
			tmp[t++] = A[j++];
		}

		i = p;
		t = 0;

		while (i <= r) { // 결과를 A 배열에 저장
			cnt++;

			if (cnt == K) {
				result = tmp[t];
				break;
			}

			A[i++] = tmp[t++];
		}
	}
}