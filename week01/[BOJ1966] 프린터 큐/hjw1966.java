import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class hjw1966 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			Queue<int[] > q = new LinkedList<>();
			int[] original = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				original[j] = Integer.parseInt(st.nextToken());
			}
			for(int j=0; j<n; j++) {
				q.add(new int[] {original[j], j});
			}
			Arrays.sort(original);
			
			int idx = n-1, cnt = 0;
			while(!q.isEmpty()) {
				int[] pk = q.poll();
				
				if(original[idx] == pk[0]) {
					cnt++;
					if(pk[1] == m) {
						sb.append(cnt).append("\n");
						break;
					}
					idx--;
				}
				else {
					q.add(pk);
				}
			}
		}
		System.out.println(sb.toString());
		
	}

}