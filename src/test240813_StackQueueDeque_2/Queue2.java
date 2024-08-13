package test240813_StackQueueDeque_2;

import java.io.*;
import java.util.*;

class Queue2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터
		StringTokenizer st; // StringTokenizer 선언

		int N = Integer.parseInt(br.readLine()); // 명령의 수

		Queue<Integer> queue = new LinkedList<>();

		int last = 0; // 마지막값을 담을 변수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			String command = st.nextToken();

			if (command.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				last = num;
				queue.add(num);
			} else if (command.equals("pop")) {
				if (queue.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(queue.poll() + "\n");
				}
			} else if (command.equals("size")) {
				bw.write(queue.size() + "\n");
			} else if (command.equals("empty")) {
				if (queue.isEmpty()) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
			} else if (command.equals("front")) {
				if (queue.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(queue.peek() + "\n");
				}
			} else if (command.equals("back")) {
				if (queue.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(last + "\n");
				}
			}
		}

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}