package test240807;

import java.io.*;
import java.util.*;

class CoordinateCompression {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터
		StringTokenizer st; // StringTokenizer 선언

		int N = Integer.parseInt(br.readLine()); // 좌표의 갯수

		int[] origin = new int[N]; // 원본 배열
		int[] sorted = new int[N]; // 정렬 할 배열
		HashMap<Integer, Integer> rankMap = new HashMap<Integer, Integer>(); // 순위 매길 HashMap

		st = new StringTokenizer(br.readLine()); // 좌표 읽어서
		for (int i = 0; i < N; i++) { // 원본과 정렬할 배열에 값 넣어 줌.
			origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(sorted); // 정렬

		int rank = 0;
		for (int val : sorted) {
			if (!rankMap.containsKey(val)) { // 순위맵의 키 값이 존재하지 않을 경우에만 키, 값 저장.
				rankMap.put(val, rank);
				rank++; // 저장 후 순위 올리기.
			}
		}

		for (int key : origin) {
			int ranking = rankMap.get(key); // 원본 배열 원소(key)에 대한 value(순위)를 갖고 옴.
			bw.write(ranking + " "); // 순위 배열 출력.
		}

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}