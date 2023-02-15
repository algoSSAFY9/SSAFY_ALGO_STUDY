import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class hjw1260 {
	static ArrayList<Integer>[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 정점 개수
		int m = Integer.parseInt(st.nextToken()); // 간선 개수
		int v = Integer.parseInt(st.nextToken()); // 탐색 시작 번호
		
		arr = new ArrayList[n+1];
		for(int i=0; i<n+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			
			arr[one].add(two);
			arr[two].add(one);
		}
		
		for(int i=1; i<n+1; i++) {
			Collections.sort(arr[i]);
		}
		
		chk = new boolean[n+1];
		chk[v] = true; // 첫 시작점 체크
		sb.append(v).append(" ");
		dfs(v);
		sb.append("\n");
		
		chk = new boolean[n+1];
		bfs(v);
		System.out.println(sb);
	}
	
	static boolean[] chk;
	static StringBuilder sb = new StringBuilder();
	static void dfs(int start) {
		
		for(int i=0; i<arr[start].size(); i++) {
			int x = arr[start].get(i);
			if(!chk[x]) {
				chk[x] = true;
				sb.append(x).append(" ");
				dfs(x);
			}
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		while(!q.isEmpty()) {
			int x = q.poll();
			chk[x] = true;
			sb.append(x).append(" ");

			for(int i=0; i<arr[x].size(); i++) {
				int re = arr[x].get(i);
				if(!chk[re]) {
					chk[re] = true;
					q.add(re);
				}
			}
		}
	}
}
