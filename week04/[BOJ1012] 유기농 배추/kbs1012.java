import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Pair{
	int y;
	int x;
	public Pair(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
public class kbs1012 {
	static boolean[][] visited;
	static boolean[][] board; // board을 매개변수로 받으면 시간 더 오래걸림 
//	static int M,N;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			board = new boolean[M][N];
			visited = new boolean[M][N];
			for(int k=0;k<K;k++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				board[a][b] = true;
			}
			int cnt = 0;
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					if(board[i][j] && !visited[i][j]) {
						visited[i][j] = true;
						cnt++;
						bfs(i,j,M,N);
					}
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int y, int x, int M, int N) {
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		
		Deque<Pair> q = new ArrayDeque<>();

		q.offer(new Pair(y,x));
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			
			for(int d=0;d<4;d++) {
				int ny = cur.y+ dy[d];
				int nx = cur.x+ dx[d];
				
				if(nx>=0&&ny>=0&&ny<M&&nx<N&&!visited[ny][nx]&&board[ny][nx]) {
					visited[ny][nx] = true;
					q.offer(new Pair(ny,nx));
				}
			}
			
		}
	}
}
