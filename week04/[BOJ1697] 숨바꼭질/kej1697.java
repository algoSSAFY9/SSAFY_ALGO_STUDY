package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class kej1697 {
	static int N, K;
	static int[] arr;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int x;
		int cnt = 0;
		arr = new int[100001];
		arr[N] = cnt;

		q.add(N);

		while (!q.isEmpty()) {
			x = q.poll();
			if(x == K) {
				break;
			}
			if (x - 1 >= 0 && arr[x - 1] == 0) {
				arr[x - 1] = arr[x] + 1;
				q.add(x - 1);
			}
			if (x + 1 <= 100000 && arr[x + 1] == 0) {
				arr[x + 1] = arr[x] + 1;
				q.add(x + 1);
			}
			if (x * 2 <= 100000 && arr[x * 2] == 0) {
				arr[x * 2] = arr[x] + 1;
				q.add(x * 2);
			}
		}
		System.out.println(arr[K]);
	}
}