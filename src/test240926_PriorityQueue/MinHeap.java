package test240926_PriorityQueue;

import java.io.*;
import java.util.*;

class MinHeap {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 연산의 개수

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());

			if (x != 0) {
				minHeap.add(x);
			} else {
				if (minHeap.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(minHeap.poll()).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}