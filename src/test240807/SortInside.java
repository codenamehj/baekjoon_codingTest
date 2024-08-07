package test240807;

import java.io.*;
import java.util.*;

class SortInside {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터

		String str = br.readLine();
		Integer[] num = new Integer[str.length()];

		for (int i = 0; i < str.length(); i++) {
			num[i] = (int) str.charAt(i);
		}

		Arrays.sort(num, Collections.reverseOrder());

		for (Integer i : num) {
			bw.write(i);
		}

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}
