package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// �ĵ��� ����
// 1 1 1 2 2 3 4 5 7 9 12 16 ...
// ��Ģ -> (n-1) +(n-5)
// ó���� �迭 int�� �����ؼ� �� Ʋ����..? �ߴµ� long���� �ٲٰ� �����..
public class kej9461 {
	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		long[] arr = new long[101];

		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		arr[4] = 2;
		arr[5] = 2;

		for (int i = 5; i <= 100; i++) {
			arr[i] = arr[i-1]+arr[i-5];
		}

		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(arr[n]).append("\n");
		}
		
		System.out.println(sb);
	}

}
