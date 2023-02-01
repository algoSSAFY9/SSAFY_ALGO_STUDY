import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class hjw7662 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			TreeMap<Integer, Integer> ts = new TreeMap<>();
			
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				char ch = st.nextToken().charAt(0);
				int put = Integer.parseInt(st.nextToken());

				if (ch == 'I') {
					ts.put(put, ts.getOrDefault(put, 0) + 1);
				} else {
					if(ts.isEmpty()) continue;
					
					int key = put == 1 ? ts.lastKey() : ts.firstKey();
					int val = ts.get(key) - 1;
					if(val == 0) {
						ts.remove(key);
					}
					else {
						ts.put(key, val);
					}
				}
			}
			if(ts.isEmpty()) sb.append("EMPTY").append("\n");
			else {
				sb.append(ts.lastKey()).append(" ").append(ts.firstKey()).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
