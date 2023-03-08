import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class hjw1764 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			set.add(line);
		}
		
		TreeSet<String> ts = new TreeSet<>();
		for(int i=0; i<M; i++) {
			String line = br.readLine();
			if(set.contains(line)) {
				ts.add(line);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(ts.size()).append("\n");
		for(String str : ts) {
			sb.append(str).append("\n");
		}
		System.out.println(sb.toString());
	}

}
