package test240809_FactorsAndMultiplesAndDecimals2_1;

import java.io.*;
import java.util.*;

class SumOfFractions {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터
		StringTokenizer st; // StringTokenizer 선언

		st = new StringTokenizer(br.readLine()); // 첫 번째 분수
		int aNum = Integer.parseInt(st.nextToken()); // 분자
		int aDenom = Integer.parseInt(st.nextToken()); // 분모

		st = new StringTokenizer(br.readLine()); // 두 번째 분수
		int bNum = Integer.parseInt(st.nextToken()); // 분자
		int bDenom = Integer.parseInt(st.nextToken()); // 분모

		int rNum = aNum * bDenom + aDenom * bNum; // 두 분수를 합한 분자
		int rDenom = aDenom * bDenom; // 두 분수를 합한 분모

		// 기약분수 : 분자, 분모의 최대 공약수로 약분한 분수
		int gcd = 1; // 최대 공약수 초기화
		int a = rNum; // 분자값 저장
		int b = rDenom; // 분모값 저장
		// 유클리드 호제법을 이용하여 최대 공약수 구하기
		while (true) {
			int r = a % b; // 나머지

			if (r == 0) {
				gcd = b;
				break;
			} else {
				a = b;
				b = r;
			}
		}

		bw.write(rNum / gcd + " " + rDenom / gcd);

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}