package test240926_BinaryNavigation_2;

import java.io.*;
import java.util.*;

class RouterInstallation {
	static int[] home;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 집의 개수
		int C = Integer.parseInt(st.nextToken()); // 공유기 개수

		home = new int[N]; // 집의 좌표 배열

		for (int i = 0; i < N; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}

		// 이분탐색을 위해 집의 좌표를 오름차순으로 정렬
		Arrays.sort(home);

		int lo = 1; // 거리의 최솟값
		int hi = home[N - 1] - home[0] + 1; // 거리의 최댓값

		while (lo < hi) {
			int mid = (lo + hi) / 2;

			// mid 거리에 대해 설치 가능한 공유기 개수가 설치하려는 공유기 갯수에 못미치면 거리를 좁힘(거리의 최댓값을 줄임)
			if (canInstall(mid) < C) {
				hi = mid;
			} else {
				// 설치 가능한 공유기 개수가 설치하려는 공유기 갯수보다 크거나 같으면 거리를 벌리면서(거리의 최솟값을 늘임) 최대 거리를 찾음
				lo = mid + 1;
			}
		}

		System.out.println(lo - 1);
	}

	// 설치 가능한 공유기의 개수를 찾는 메소드
	static int canInstall(int distance) {
		int count = 1; // 첫 번째 집은 무조건 설치
		int lastLocate = home[0];

		for (int i = 1; i < home.length; i++) {
			int locate = home[i];

			// 현재 탐색하는 집의 위치와 직전에 설치한 집의 위치 간의 거리가 최소 거리보다 크거나 같을 때 
			// 공유기 설치 개수를 늘려주고 마지막 설치 위치를 갱신해줌
			if (locate - lastLocate >= distance) {
				count++;
				lastLocate = locate;
			}
		}

		return count;
	}
}