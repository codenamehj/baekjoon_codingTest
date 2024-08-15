package test240815_Deepening2;

import java.io.*;
import java.util.*;

class ABrightGreetingGomgomi {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터

		int N = Integer.parseInt(br.readLine()); // 채팅방의 기록 수
		int count = 0;
		HashSet<String> hashSet = new HashSet<>();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();

			if (s.equals("ENTER")) {
				hashSet.clear();
			} else {
				if (hashSet.add(s))
					count++;
			}
		}

		bw.write(count + "\n");

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}