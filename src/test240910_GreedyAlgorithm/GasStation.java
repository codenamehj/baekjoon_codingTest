package test240910_GreedyAlgorithm;

import java.io.*;
import java.util.*;

class GasStation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		int N = Integer.parseInt(br.readLine()); // 도시의 수

		long[] distance = new long[N - 1];
		long[] cost = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			distance[i] = Long.parseLong(st.nextToken()); // 도시 사이의 거리
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cost[i] = Long.parseLong(st.nextToken());
		}

		long price = 0;
		long minCost = cost[0];

		for (int i = 0; i < N - 1; i++) {
			if (cost[i] < minCost) {
				minCost = cost[i];
			}
			price += (minCost * distance[i]);
		}

		System.out.println(price);
	}
}