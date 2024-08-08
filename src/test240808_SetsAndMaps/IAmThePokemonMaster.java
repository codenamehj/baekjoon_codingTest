package test240808_SetsAndMaps;

import java.io.*;
import java.util.*;

class IAmThePokemonMaster {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터
		StringTokenizer st; // StringTokenizer 선언

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 도감에 수록된 포켓몬 수
		int M = Integer.parseInt(st.nextToken()); // 문제 수

		HashMap<Integer, String> dogam = new HashMap<Integer, String>(); // 포켓몬 도감
		HashMap<String, Integer> vkdogam = new HashMap<String, Integer>(); // 키 값 반대 포켓몬 도감

		for (int i = 0; i < N; i++) {
			String pokemon = br.readLine();
			dogam.put(i + 1, pokemon);
			vkdogam.put(pokemon, i + 1);
		}

		for (int i = 0; i < M; i++) {
			String quiz = br.readLine();

			if (quiz.matches("[+-]?\\d*(\\.\\d+)?")) {
				bw.write(dogam.get(Integer.parseInt(quiz)) + "\n");
			} else {
				bw.write(vkdogam.get(quiz) + "\n");
			}
		}
		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}
