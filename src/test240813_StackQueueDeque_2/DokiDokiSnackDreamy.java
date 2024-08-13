package test240813_StackQueueDeque_2;

import java.io.*;
import java.util.*;

class DokiDokiSnackDreamy {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Queue<Integer> queue = new LinkedList<>(); // 대기열 큐(FIFO)
		Stack<Integer> stack = new Stack<>(); // 추가 대기열 스택(LIFO)

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			queue.add(Integer.parseInt(st.nextToken()));
		}

		int seq = 1; // 순서

		while (!queue.isEmpty()) {
			if (queue.peek() == seq) {
				queue.poll();
				seq++;
			} else if (!stack.isEmpty() && stack.peek() == seq) {
				stack.pop();
				seq++;
			} else {
				stack.add(queue.poll());
			}
		}
		while (!stack.isEmpty()) {
			if (stack.peek() == seq) {
				stack.pop();
				seq++;
			} else {
				System.out.println("Sad");
				return;
			}
		}
		System.out.println("Nice");
	}
}
