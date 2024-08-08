package test240808_SetsAndMaps;

import java.io.*;
import java.util.*;

class SymmetricDifference {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터
		StringTokenizer st; // StringTokenizer 선언

		st = new StringTokenizer(br.readLine());
		int AN = Integer.parseInt(st.nextToken()); // 집합 A 원소의 갯수
		int BN = Integer.parseInt(st.nextToken()); // 집합 B 원소의 갯수

		st = new StringTokenizer(br.readLine());
		HashSet<String> A = new HashSet<String>();
		for (int i = 0; i < AN; i++) {
			A.add(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		HashSet<String> B = new HashSet<String>();
		for (int i = 0; i < BN; i++) {
			B.add(st.nextToken());
		}

		int result = 0;
		for (String num : A) {
			if (!B.contains(num)) {
				result++;
			}
		}

		for (String num : B) {
			if (!A.contains(num)) {
				result++;
			}
		}

		bw.write(result + "");

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}
