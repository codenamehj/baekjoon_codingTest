package test240925_BinaryNavigation_1;

import java.io.*;
import java.util.*;

class CutTheLANCable {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 개수
		int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

		int[] arr = new int[K]; // 가지고 있는 랜선의 길이를 저장하는 배열

		long max = 0; // 최대 랜선의 길이

		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		max++; // mid가 0이 되는 것을 방지하기 위해 max에 1을 더해줌

		long min = 0; // 탐색 길이 최솟값
		long mid = 0;

		while (min < max) {
			// 범위 내에서 중간 길이를 구함
			mid = (min + max) / 2;

			long count = 0;

			// 구해진 중간 길이로 잘라서 랜선이 총 몇 개 만들어지는지 구함.
			for (int i = 0; i < arr.length; i++) {
				count += (arr[i] / mid);
			}

			// 잘라진 랜선의 개수가 만들려고 하는 개수보다 적으면 최대 길이를 줄이고 적지 않으면 최소 길이를 늘림
			if (count < N) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}

		System.out.println(max - 1);
	}
}