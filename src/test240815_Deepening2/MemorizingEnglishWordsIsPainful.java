package test240815_Deepening2;

import java.io.*;
import java.util.*;

class MemorizingEnglishWordsIsPainful {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 단어의 개수
		int M = Integer.parseInt(st.nextToken()); // 외울 단어의 길이 기준

		HashMap<String, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			if (word.length() < M)
				continue;

			hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
		}

		List<String> vocaBook = new ArrayList<>(hashMap.keySet());

		Collections.sort(vocaBook, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// 자주 나오는 단어일수록 앞에 배치
				if (Integer.compare(hashMap.get(o1), hashMap.get(o2)) != 0) {
					return Integer.compare(hashMap.get(o2), hashMap.get(o1));
				}
				// 단어의 길이가 길수록 앞에 배치 
				if (o1.length() != o2.length()) {
					return o2.length() - o1.length();
				}
				// 알파벳 사전 순으로 배치
				return o1.compareTo(o2);
			}
		});

		for (String word : vocaBook) {
			bw.write(word + "\n");
		}

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}