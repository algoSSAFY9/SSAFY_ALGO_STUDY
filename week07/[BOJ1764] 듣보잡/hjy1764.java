import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class hjy1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> hset1 = new HashSet<>();
		HashSet<String> rst = new HashSet<>();
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			hset1.add(br.readLine());
		}
		
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if(hset1.contains(str)){
				rst.add(str);
				cnt++;
			}
		}
		sb.append(cnt).append("\n");
		ArrayList<String> n_rst = new ArrayList<>(rst);
		Collections.sort(n_rst);
		for (int i = 0; i < n_rst.size(); i++) {
			sb.append(n_rst.get(i)).append("\n");
		}
		System.out.println(sb);
	}
}
