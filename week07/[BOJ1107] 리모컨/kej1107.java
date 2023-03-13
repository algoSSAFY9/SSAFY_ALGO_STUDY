package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1107_리모컨 {
	static int N, M;
	static int[] num = new int[10];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			num[Integer.parseInt(st.nextToken())] = -1;
		}

		boolean flag = true;
		for (int i = 0; i <= 999999; i++) { // 그냥 다 돌아볼까..?
			String s = String.valueOf(i);

			for (int j = 0; j < s.length(); j++) {
				for (int z = 0; z < num.length; z++) {
					if (num[z] == s.charAt(j)) {
						flag = false;
						break;
					}
				}
			}

			int cnt = 0;
			if (flag) {
				for (int j = i; j <= N; j++) {
					cnt++;
				}
			}
			

		}
	}

}
