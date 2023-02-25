package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kej14889 {
	static int N;
	static int[][] list;
	static boolean[] select;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		list = new int[N][N];
		select = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		comb(0, 0);
		System.out.println(result);
	}

	static void comb(int tgtIdx, int srcIdx) {
		if (tgtIdx == N / 2) {
			Check();
			return;
		}

		for (int i = srcIdx; i < N; i++) {
			if(select[i]) continue;
			select[i] = true;
			comb(tgtIdx + 1, i + 1);
			select[i] = false;
		}
	}

	static void Check() {
		int S = 0;
		int L = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (select[i] == true && select[j] == true) { // �湮 true�� ��ŸƮ ��
					S += list[i][j] + list[j][i];
				}
				else if (select[i] == false && select[j] == false) { // false�� ��ũ ��
					L += list[i][j] + list[j][i];
				}
			}
		}
		int min = Math.abs(S-L);
		if(min == 0) {
			System.out.println(0);
			System.exit(0);
		}
		result = Math.min(min, result);
	}
}
