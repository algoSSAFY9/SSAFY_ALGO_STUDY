import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hjy11724 {
	static int map[][];
	static boolean isVisited[];	// 정점의 방문 여부
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 		// 정점의 개수
		int M = Integer.parseInt(st.nextToken()); 	// 간선의 개수
		
		map = new int[N+1][N+1];
		isVisited = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			// 방향 없는 그래프
			map[u][v] = 1;
			map[v][u] = 1;
		}
		
		int cnt = 0;	// 연결 요소 개수
		for(int i = 1; i <= N; i++) {	
			if(isVisited[i] == false) {
				dfs(i);				
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	static void dfs(int u) {
		
		if(isVisited[u] == true) {
			return;
		}

		isVisited[u] = true;
		for(int i = 1; i <= N; i++) {
			// 정점과 연결된 정점 있을 경우 : 연결된 정점 방문
			if(map[u][i] == 1) {
				dfs(i);
			}
		}
	}

}
