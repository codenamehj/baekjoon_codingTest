package test240807_Sort;

import java.io.*;
import java.util.*;

class SortCoordinates {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 버퍼라이터
		StringTokenizer st; // StringTokenizer 선언

		int N = Integer.parseInt(br.readLine());
		int[][] xy = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			xy[i][0] = Integer.parseInt(st.nextToken());
			xy[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(xy, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
			else return o1[0] - o2[0];
		});

        for(int i = 0; i < N; i++){
            for(int j = 0; j < 2; j++){
                bw.write(xy[i][j] + " ");
            }
            bw.write("\n");
        }

		bw.flush(); // 남아있는 데이터를 모두 출력시킴
		bw.close(); // 스트림을 닫음
	}
}
