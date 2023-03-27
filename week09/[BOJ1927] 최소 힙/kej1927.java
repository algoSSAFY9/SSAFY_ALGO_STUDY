package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class kej1927 {
	// ÃÖ¼Ò Èü
	static int N;
	static PriorityQueue<Integer> q = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (q.isEmpty()) {
					sb.append("0").append("\n");
				} else {
					sb.append(q.poll()).append("\n");
				}
			}
			else {
				q.add(x);
			}
		}
		System.out.println(sb);
	}

}
