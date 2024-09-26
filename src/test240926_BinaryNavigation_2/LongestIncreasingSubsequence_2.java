package test240926_BinaryNavigation_2;

import java.io.*;
import java.util.*;

class LongestIncreasingSubsequence_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		int N = Integer.parseInt(br.readLine()); // 수열 A의 크기

		int[] A = new int[N];
		int[] LIS = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		// LIS 초기 값으로 첫 번째 수열의 값을 가짐
		LIS[0] = A[0];
		int lengthOfLIS = 1;

		for (int i = 1; i < N; i++) {

			int key = A[i];

			// 만약 key가 LIS의 마지막 값보다 클 경우 추가해 줌
			if (LIS[lengthOfLIS - 1] < key) {
				lengthOfLIS++;
				LIS[lengthOfLIS - 1] = key;
			} else {
				// Lower Bound 이분탐색을 진행한다.
				int lo = 0;
				int hi = lengthOfLIS;

				while (lo < hi) {
					int mid = (lo + hi) / 2;

					if (LIS[mid] < key) {
						lo = mid + 1;
					} else {
						hi = mid;
					}
				}
				// lo가 LIS에서 대치 될 원소의 위치가 될 것이고 해당 위치에 key 값으로 원소를 바꿔 줌
				LIS[lo] = key;
			}
		}

		// 위 과정을 통해 나온 LIS의 길이를 출력
		System.out.println(lengthOfLIS);
	}
}