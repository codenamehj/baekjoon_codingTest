package test240910_GreedyAlgorithm;

import java.io.*;
import java.util.*;

class Coin0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 동전의 종류
		int K = Integer.parseInt(st.nextToken()); // 만들어야하는 돈의 액수

		Integer[] coins = new Integer[N]; // 동전의 가치 배열

		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		// 동전 가치가 큰 동전부터 정렬
		Arrays.sort(coins, Collections.reverseOrder());

		int count = 0; // 필요한 동전 개수의 최솟값

		for (int i = 0; i < coins.length; i++) {
			count += K / coins[i];
			K %= coins[i];
		}

		if (K == 0) {
			System.out.println(count);
		}
	}
}