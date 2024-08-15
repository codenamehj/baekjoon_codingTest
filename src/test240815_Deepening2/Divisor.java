package test240815_Deepening2;

import java.io.*;
import java.util.*;

class Divisor {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터
		StringTokenizer st; // StringTokenizer 선언

		int N = Integer.parseInt(br.readLine()); // 진짜 약수의 개수

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken()); // 첫번째 호출
			arr[i] = num;
		}

		Arrays.sort(arr);

		if (N % 2 == 0) {
			bw.write(arr[0] * arr[arr.length - 1] + "\n");
		} else {
			bw.write(arr[arr.length / 2] * arr[arr.length / 2] + "\n");
		}

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}