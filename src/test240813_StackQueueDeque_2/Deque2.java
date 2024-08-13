package test240813_StackQueueDeque_2;

import java.io.*;
import java.util.*;

class Deque2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터
		StringTokenizer st; // StringTokenizer 선언

		int N = Integer.parseInt(br.readLine()); // 명령의 수

		Deque<Integer> deque = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int command = Integer.parseInt(st.nextToken());

			if (command == 1) {
				int num = Integer.parseInt(st.nextToken());

				deque.addFirst(num);
			} else if (command == 2) {
				int num = Integer.parseInt(st.nextToken());

				deque.addLast(num);
			} else if (command == 3) {
				if (deque.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(deque.removeFirst() + "\n");
				}
			} else if (command == 4) {
				if (deque.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(deque.removeLast() + "\n");
				}
			} else if (command == 5) {
				bw.write(deque.size() + "\n");
			} else if (command == 6) {
				if (deque.isEmpty()) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
			} else if (command == 7) {
				if (deque.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(deque.peekFirst() + "\n");
				}
			} else if (command == 8) {
				if (deque.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(deque.peekLast() + "\n");
				}
			}
		}

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}