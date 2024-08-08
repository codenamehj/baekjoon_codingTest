package test240807_Sort;

import java.io.*;
import java.util.*;

public class SortByAge {
	static class Member {
		private int age;
		private String name;

		public Member() {
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터
		StringTokenizer st; // StringTokenizer 선언

		int N = Integer.parseInt(br.readLine()); // 회원의 수

		Member[] mem = new Member[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int age = Integer.parseInt(st.nextToken()); // 나이
			String name = st.nextToken(); // 이름

			mem[i] = new Member();

			mem[i].age = age;
			mem[i].name = name;
		}

		Arrays.sort(mem, new Comparator<Member>() {
			@Override
			public int compare(Member m1, Member m2) {
				return m1.getAge() - m2.getAge();
			}
		});

		for (Member member : mem) {
			bw.write(member.getAge() + " ");
			bw.write(member.getName() + "\n");
		}

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}