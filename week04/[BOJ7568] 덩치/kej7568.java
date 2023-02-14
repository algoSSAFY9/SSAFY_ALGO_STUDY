package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kej7568 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		int rank;
		for (int tc = 0; tc < N; tc++) {
			st = new StringTokenizer(br.readLine());
			arr[tc][0] = Integer.parseInt(st.nextToken());
			arr[tc][1] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			rank = 1;
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1])
					rank++;
			}
			sb.append(rank).append(" ");
		}
		System.out.println(sb);
	}

}
