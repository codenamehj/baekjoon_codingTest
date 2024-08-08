package test240808_SetsAndMaps;

import java.io.*;
import java.util.*;

class SetOfStrings {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터
		StringTokenizer st; // StringTokenizer 선언

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 기준 문자열 갯수
		int M = Integer.parseInt(st.nextToken()); // 찾을 문자열 갯수

		HashSet<String> str = new HashSet<String>(); // 기준 문자열을 담을 HashSet 생성

		for (int i = 0; i < N; i++) { // 기준 문자열 담기
			str.add(br.readLine());
		}

		int count = 0;
		for (int i = 0; i < M; i++) {
			String fstr = br.readLine(); // 찾을 문자열 변수에 담기

			if (str.contains(fstr)) // 찾을 문자열 유무 판별
				count++;

		}

		bw.write(count + " "); // 갯수 출력

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}
