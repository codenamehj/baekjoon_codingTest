package test240808_SetsAndMaps;

import java.io.*;
import java.util.*;

class UnheardOf {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터
		StringTokenizer st; // StringTokenizer 선언

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람 수
		int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람 수

		HashMap<String, String> unheard = new HashMap<String, String>(); // 듣도 못한 사람들 HashSet

		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			unheard.put(name, name);
		}

		ArrayList<String> result = new ArrayList<String>();

		for (int i = 0; i < M; i++) {
			String nosee = br.readLine();

			if (unheard.containsKey(nosee)) {
				result.add(nosee);
			}
		}

		Collections.sort(result);

		bw.write(result.size() + "\n");

		for (String name : result) {
			bw.write(name + "\n");
		}

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}
