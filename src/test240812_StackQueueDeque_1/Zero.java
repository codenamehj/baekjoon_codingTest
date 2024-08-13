package test240812_StackQueueDeque_1;

import java.io.*;
import java.util.*;

class Zero {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터

		int K = Integer.parseInt(br.readLine());

		Stack<Integer> intStack = new Stack<Integer>();

		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) {
				intStack.pop();
			} else {
				intStack.push(num);
			}
		}

		int sum = 0;
		while (!intStack.isEmpty()) {
			sum += intStack.pop();
		}

		bw.write(sum + "\n");

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}