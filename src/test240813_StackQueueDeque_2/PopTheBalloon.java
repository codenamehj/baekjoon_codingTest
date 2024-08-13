package test240813_StackQueueDeque_2;

import java.io.*;
import java.util.*;

class PopTheBalloon {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터
		StringTokenizer st; // StringTokenizer 선언

		int N = Integer.parseInt(br.readLine());

		Deque<int[]> deque = new ArrayDeque<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int[] balloon = { i + 1, Integer.parseInt(st.nextToken()) };
			deque.add(balloon);
		}

		while (deque.size() > 1) {
			int[] balloon = deque.pollFirst();
			bw.write(balloon[0] + " ");

			int n = balloon[1];
			if (n > 0) {
				for (int j = 1; j < n; j++) {
					deque.addLast(deque.pollFirst());
				}
			} else if (n < 0) {
				for (int j = n; j < 0; j++) {
					deque.addFirst(deque.pollLast());
				}
			}
		}
		bw.write(deque.poll()[0] + " ");

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}