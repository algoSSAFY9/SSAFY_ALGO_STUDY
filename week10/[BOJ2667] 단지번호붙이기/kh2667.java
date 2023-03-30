import java.io.*;
import java.util.*;

public class kh2667 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 2][N + 2];
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= N; j++) {
				map[i][j] = str.charAt(j - 1) - '0';
			}
		}

		ArrayList<Integer> arr = new ArrayList<>();
		int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 1) {
					Deque<int[]> q = new ArrayDeque<>();
					q.offer(new int[] { i, j });
					map[i][j] = 0;
					int size = 1;
					while (!q.isEmpty()) {
						int[] rc = q.poll();
						for (int[] d : directions) {
							int next_r = rc[0] + d[0], next_c = rc[1] + d[1];
							if (map[next_r][next_c] == 1) {
								q.offer(new int[] { next_r, next_c });
								map[next_r][next_c] = 0;
								size++;
							}
						}
					}

					arr.add(size);
				}
			}
		}

		arr.sort(Comparator.naturalOrder());

		sb.append(arr.size()).append("\n");
		for (int i : arr) sb.append(i).append("\n");
		System.out.println(sb);
	}
}
