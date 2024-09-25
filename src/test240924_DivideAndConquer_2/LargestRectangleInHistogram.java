package test240924_DivideAndConquer_2;

import java.io.*;
import java.util.*;

class LargestRectangleInHistogram {
	static int[] h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());

			if (n == 0)
				break;

			h = new int[n];

			for (int i = 0; i < n; i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}
			sb.append(getArea(0, n - 1)).append("\n");
			h = null;
		}
		System.out.println(sb);
	}

	static long getArea(int lo, int hi) {
		if (lo == hi) // 막대의 폭이 1일 경우 높이가 넓이가 되어 바로 반환
			return h[lo];

		int mid = (lo + hi) / 2; // 중간 지점

		// 중간 지점을 기준으로 양쪽으로 나누어 구간의 넓이를 구함
		long lArea = getArea(lo, mid);
		long rArea = getArea(mid + 1, hi);
		// 양쪽 구간 중 큰 넓이 저장
		long max = Math.max(lArea, rArea);

		max = Math.max(max, getMidArea(lo, hi, mid));

		return max;
	}

	// 확장하는 영역의 넓이를 구하는 메소드
	static long getMidArea(int lo, int hi, int mid) {
		int toLeft = mid; // 중간 지점으로부터 왼쪽으로 갈 변수
		int toRight = mid; // 중간 지점으로부터 오른쪽으로 갈 변수

		long height = h[mid]; // 높이

		long maxArea = height; // 최대 넓이 초기화

		// 양 끝 범위를 벗어나기 전까지 반복
		while (lo < toLeft && toRight < hi) {
			// 양쪽 다음 칸의 높이 중 높은 값을 선택하되, 갱신되는 높이는 기존 높이보다 작거나 같아야 함
			if (h[toLeft - 1] < h[toRight + 1]) {
				toRight++;
				height = Math.min(height, h[toRight]);
			} else {
				toLeft--;
				height = Math.min(height, h[toLeft]);
			}

			// 최대 넓이 갱신
			maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
		}

		// 오른쪽 구간을 끝까지 탐색하지 못했다면 마저 탐색
		while (toRight < hi) {
			toRight++;
			height = Math.min(height, h[toRight]);
			maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
		}

		// 왼쪽 구간을 끝까지 탐색하지 못했다면 마저 탐색
		while (lo < toLeft) {
			toLeft--;
			height = Math.min(height, h[toLeft]);
			maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
		}

		return maxArea;
	}

}