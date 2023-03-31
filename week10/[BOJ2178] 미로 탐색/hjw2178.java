import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class hjw2178 {
	static int N, M;
	static int[][] miro;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		miro = new int[N][M];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				miro[i][j] = line.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		Queue<int[] > q = new LinkedList<>();
		q.add(new int[] {0, 0, 1});
		
		boolean[][] chk = new boolean[N][M];
		chk[0][0] = true;
		while(!q.isEmpty()) {
			int[] pol = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = dx[i] + pol[0];
				int ny = dy[i] + pol[1];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || miro[nx][ny] == 0 || chk[nx][ny]) continue;
				if(nx == N-1 && ny == M-1) {
					return pol[2] + 1;
				}
				chk[nx][ny] = true;
				q.add(new int[] {nx, ny, pol[2] + 1});
			}
			
		}
		return -1;
	}
}
