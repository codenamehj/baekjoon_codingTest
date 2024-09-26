package test240926_PriorityQueue;

import java.io.*;
import java.util.*;

class AbsoluteValueHeap {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 연산의 개수

		PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);

			if (abs1 == abs2)
				return o1 - o2;
			return abs1 - abs2;
		});

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());

			if (x != 0) {
				heap.add(x);
			} else {
				if (heap.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(heap.poll()).append("\n");
				}
			}
		}

		System.out.println(sb);
	}
}