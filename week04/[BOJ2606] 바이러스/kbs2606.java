import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 배열 */
public class kbs2606 {
	static boolean[][] comLinks;
	static boolean[] virusList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int coms = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		comLinks = new boolean[coms + 1][coms + 1];
		virusList = new boolean[coms + 1];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			comLinks[a][b] = true;
			comLinks[b][a] = true;
		}

		for (int i = 1; i < comLinks.length; i++) {
			if (comLinks[1][i]) {
				check(i);
				virusList[i] = true;
			}

		}

		// result
		int cnt = 0;
		for (int i = 2; i <= (coms); i++) {
			if (virusList[i])
				cnt++;
		}
		System.out.println(cnt);
	}

	public static void check(int cur) {
		for (int i = 0; i < comLinks.length; i++) {
			if (!virusList[i] && comLinks[cur][i]) {
				virusList[i] = true;
				check(i);
			}
		}
	}
}
