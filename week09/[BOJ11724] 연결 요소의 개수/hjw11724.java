import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class hjw11724 {
	static ArrayList<Integer>[] arr;
	static boolean[] chk;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[n+1];
		chk = new boolean[n+1];
		
		for(int i=0; i<=n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			arr[u].add(v);
			arr[v].add(u);
		}
		
		int cnt = 0;
		for(int i=1; i<=n; i++) {
			if(!chk[i]) {
				chk[i] = true;
				cnt++;
				cal(i);
			}
		}
		
		System.out.println(cnt);
	}
	
	static void cal(int start) {
		for(int i=0; i<arr[start].size(); i++) {
			int x = arr[start].get(i);
			if(!chk[x]) {
				chk[x] = true;
				cal(x);
			}
		}
	}
}
