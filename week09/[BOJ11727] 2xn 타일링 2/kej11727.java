package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// 2×n 타일링 2

public class kej11727 {
	static int N;
	static int[] cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cnt = new int[1001];

		cnt[1] = 1;
		cnt[2] = 3;

		for (int i = 3; i <= N; i++) {
			cnt[i] = (cnt[i - 1] + cnt[i - 2] * 2) % 10007;
		}

		System.out.println(cnt[N]);
	}

}
