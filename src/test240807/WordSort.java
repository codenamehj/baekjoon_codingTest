package test240807;

import java.io.*;
import java.util.*;

class WordSort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터

		int N = Integer.parseInt(br.readLine());

		String[] word = new String[N];

		for (int i = 0; i < N; i++) {
			word[i] = br.readLine();
		}

		String[] newWord = Arrays.stream(word).distinct().toArray(String[]::new);

		Arrays.sort(newWord, (String s1, String s2) -> {
			if (s1.length() == s2.length())
				return s1.compareTo(s2);
			else
				return s1.length() - s2.length();
		});

		for (String str : newWord) {
			bw.write(str + "\n");
		}

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}
