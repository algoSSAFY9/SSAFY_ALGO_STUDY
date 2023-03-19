import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class hjw9375 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			HashMap<String, Integer> hm = new HashMap<>();
			
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String jong = st.nextToken();
				hm.put(jong, hm.getOrDefault(jong, 0) + 1);
			}
			
			int res = 1;
			for(int x : hm.values()) {
				res *= x + 1;
			}

			sb.append(res-1).append("\n");
		}
		System.out.println(sb.toString());
	}

}
