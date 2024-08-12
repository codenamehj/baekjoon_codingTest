package test240809_FactorsAndMultiplesAndDecimals2;

import java.io.*;

class Colonnade {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터

		int N = Integer.parseInt(br.readLine()); // 이미 심어져 있는 가로수의 수

		int[] tree = new int[N]; // 심어져 있는 가로수의 좌표 배열 생성

		for (int i = 0; i < N; i++) { // 가로수 좌표값 배열에 넣기
			tree[i] = Integer.parseInt(br.readLine());
		}

		// 최대 공약수 찾는 함수를 호출하여 거리들의 최대 공약수 찾기
		int gcd = 0;
		for (int i = 0; i < tree.length - 1; i++) {
			int distance = tree[i + 1] - tree[i];

			gcd = findGcd(distance, gcd);
		}

		bw.write((tree[N - 1] - tree[0]) / gcd + 1 - tree.length + " ");

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}

	static int findGcd(int a, int b) { // 최대 공약수 찾는 함수
		if (b == 0) {
			return a;
		}
		return findGcd(b, a % b);
	}
}