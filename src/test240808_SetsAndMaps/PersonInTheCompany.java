package test240808_SetsAndMaps;

import java.io.*;
import java.util.*;

class PersonInTheCompany {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터
		StringTokenizer st; // StringTokenizer 선언

		int n = Integer.parseInt(br.readLine()); // 출입 기록의 수

		HashMap<String, String> record = new HashMap<String, String>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			String name = st.nextToken();
			String state = st.nextToken();

			if (record.containsKey(name)) {
				record.replace(name, state);
			} else {
				record.put(name, state);
			}
		}

		ArrayList<String> result = new ArrayList<String>();

		for (String key : record.keySet()) {
			if (record.get(key).equals("enter")) {
				result.add(key);
			}
		}

		result.sort(Comparator.reverseOrder());

		for (String name : result) {
			System.out.println(name);
		}

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}
