package test240813_StackQueueDeque_2;

import java.io.*;
import java.util.*;

class Card2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		System.out.print("<");

		while (!queue.isEmpty()) {
			for (int i = 1; i < K; i++) {
				queue.add(queue.poll());
			}
			System.out.print(queue.poll());
			if (!queue.isEmpty()) {
				System.out.print(", ");
			}
		}
		System.out.print(">");
	}
}