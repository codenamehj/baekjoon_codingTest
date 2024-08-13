package test240813_StackQueueDeque_2;

import java.io.*;
import java.util.*;

class QueueStack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터
		StringTokenizer st; // StringTokenizer 선언

		int N = Integer.parseInt(br.readLine()); // 자료구조 갯수

		int[] sArr = new int[N]; // 자료구조 배열

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) { // 자료구조 배열에 어떤 자료구조인지 입력(0: 큐, 1: 스택)
			sArr[i] = Integer.parseInt(st.nextToken());
		}

		Deque<Integer> deque = new ArrayDeque<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (sArr[i] == 0)
				deque.addLast(num);
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			deque.addFirst(Integer.parseInt(st.nextToken()));
			bw.write(deque.pollLast() + " ");
		}
		bw.flush();
	}
}