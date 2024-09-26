package test240926_PriorityQueue;

import java.io.*;
import java.util.*;

class MaxHeap {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 연산의 개수

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());

			if (x != 0) {
				maxHeap.add(x);
			} else {
				if (maxHeap.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(maxHeap.poll()).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}