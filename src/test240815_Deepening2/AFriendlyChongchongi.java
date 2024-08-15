package test240815_Deepening2;

import java.io.*;
import java.util.*;

class AFriendlyChongchongi {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 만난 사람들의 기록 수

		HashSet<String> rainbowDance = new HashSet<>(); // 무지개 댄스를 추는 사람들 HashSet
		rainbowDance.add("ChongChong"); // 처음에는 총총이 혼자 춤을 추고 있음.

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String person1 = st.nextToken();
			String person2 = st.nextToken();

			// 무지개 댄스를 추는 사람과 만나면 만난 사람도 무지개 댄스를 추게 됨.
			if (rainbowDance.contains(person1) || rainbowDance.contains(person2)) { 
				rainbowDance.add(person1);
				rainbowDance.add(person2);
			}
		}

		bw.write(rainbowDance.size() + "\n");

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}