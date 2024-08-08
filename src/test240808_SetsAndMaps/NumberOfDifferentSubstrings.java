package test240808_SetsAndMaps;

import java.io.*;
import java.util.*;

class NumberOfDifferentSubstrings {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터

		String S = br.readLine(); // 문자열

		HashSet<String> substr = new HashSet<String>();

		for (int i = 0; i < S.length(); i++) {
			for (int j = i + 1; j <= S.length(); j++) {
				substr.add(S.substring(i, j));
			}
		}

		bw.write(substr.size() + "");

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}
