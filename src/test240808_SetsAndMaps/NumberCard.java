package test240808_SetsAndMaps;

import java.io.*;
import java.util.*;

class NumberCard {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터
		StringTokenizer st; // StringTokenizer 선언

		int N = Integer.parseInt(br.readLine()); // 가지고 있는 카드의 수

		HashSet<String> card = new HashSet<String>(); // 카드 번호를 담을 HashSet 생성

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) { // 배열에 가지고 있는 카드 번호 담기
			card.add(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine()); // 찾아야하는 숫자의 수

		int[] result = new int[M]; // 결과 배열 생성

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			String num = st.nextToken(); // 찾을 숫자 변수에 담기

			if (card.contains(num)) // 찾을 숫자 카드 유무 판별
				result[i] = 1;

		}

		for (int c : result) { // 카드 갯수 출력
			bw.write(c + " ");
		}

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}
