import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class kbs22858 {
	static StringTokenizer st;
	static int[] si;
	static int[] movei;
	static Map<Integer, Integer> di = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		si = new int[N + 1];
		movei = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			movei[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			si[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			di.put(i, Integer.parseInt(st.nextToken()));
		}

		for (int k = 0; k < K; k++) {
			for (int i = 1; i <= N; i++) {
				int tmp = di.get(movei[i]);
				movei[i] = tmp;
			}
		}

		// output
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(si[movei[i]]).append(" ");
		}
		System.out.println(sb);
	}
}