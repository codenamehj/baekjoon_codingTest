package test240812_StackQueueDeque_1;

import java.io.*;
import java.util.*;

class Parentheses {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			sb.append(pString(br.readLine())).append('\n');
		}

		System.out.println(sb);
	}

	public static String pString(String s) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);

			// 여는 괄호일 경우 스택에 넣는다.
			if (c == '(') {
				stack.push(c);
			}

			// 닫는 괄호를 입력받았으나 pop할 원소가 없을 경우
			else if (stack.empty()) {
				return "NO";
			}
			// 그 외의 경우 stack 원소를 pop
			else {
				stack.pop();
			}
		}

		if (stack.empty()) { // 스택이 비어있으면 VPS
			return "YES";
		} else {
			return "NO";
		}
	}
}