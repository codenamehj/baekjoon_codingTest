package test240925_BinaryNavigation_1;

import java.io.*;
import java.util.*;

class CutTheLANCable {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] arr = new int[K];

		long max = 0;

		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		max++;

		long min = 0;
		long mid = 0;

		while (min < max) {
			mid = (min + max) / 2;

			long count = 0;

			for (int i = 0; i < arr.length; i++) {
				count += (arr[i] / mid);
			}

			if (count < N) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}

		System.out.println(min - 1);
	}
}