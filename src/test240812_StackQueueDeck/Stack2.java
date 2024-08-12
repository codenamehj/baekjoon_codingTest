package test240812_StackQueueDeck;

import java.io.*;
import java.util.*;

class Stack2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터
		StringTokenizer st; // StringTokenizer 선언

		int N = Integer.parseInt(br.readLine()); // 명령의 수

		Stack<Integer> intStack = new Stack<Integer>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int command = Integer.parseInt(st.nextToken());

			if (command == 1) {
				int num = Integer.parseInt(st.nextToken());

				intStack.push(num);
			} else if (command == 2) {
				if (intStack.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(intStack.pop() + "\n");
				}
			} else if (command == 3) {
				bw.write(intStack.size() + "\n");
			} else if (command == 4) {
				if (intStack.isEmpty()) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
			} else if (command == 5) {
				if (intStack.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(intStack.peek() + "\n");
				}
			}
		}

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}