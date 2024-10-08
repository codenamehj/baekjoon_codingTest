package test240910_GreedyAlgorithm;

import java.io.*;
import java.util.*;

class MeetingRoomAssignment {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		int N = Integer.parseInt(br.readLine()); // 회의의 수

		// time[][0]은 시작 시각, time[][1]은 종료 시각
		int[][] time = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
			time[i][1] = Integer.parseInt(st.nextToken()); // 종료시간
		}

		// 종료시간을 기준으로 정렬
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// 종료 시간이 같을 경우 시작시간이 빠른 순으로 정렬
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});

		int count = 0;
		int prev_end_time = 0; // 직전 종료 시간

		for (int i = 0; i < N; i++) {
			// 직전 종료 시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
			if (prev_end_time <= time[i][0]) {
				prev_end_time = time[i][1];
				count++;
			}
		}

		System.out.println(count);
	}
}