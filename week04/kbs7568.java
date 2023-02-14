import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class kbs7568 {
	public static class Pair {
		int kg;
		int cm;

		Pair(int kg, int cm) {
			this.kg = kg;
			this.cm = cm;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// HashMap : 저장되는 순서가 유지되지 않지만, LinkedHashMap은 유지됨
		// HashMap, LinkedHashMap : 둘다 중복 key 없음 -> 오답 이유
		int n = Integer.parseInt(br.readLine());
		List<Pair> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int kg = Integer.parseInt(st.nextToken());
			int cm = Integer.parseInt(st.nextToken());
			arr.add(new Pair(kg, cm));
		}

		for (int i = 0; i < n; i++) {
			Pair p = arr.get(i);

			int cnt = 0;
			for (int j = 0; j < n; j++) {
				Pair p2 = arr.get(j);
				if (p.kg < p2.kg && p.cm < p2.cm)
					cnt++;
			}
			sb.append(cnt + 1).append(" ");
		}
		System.out.println(sb);
	}
}
