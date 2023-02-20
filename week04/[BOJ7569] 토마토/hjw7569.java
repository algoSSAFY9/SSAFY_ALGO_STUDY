import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class hjw7569 {
	static int m, n, h, count = 0, chk = 0;
	static int[][][] tomato;
	static boolean[][][] check;
	static Queue<int[] > q = new LinkedList<int[]>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); // 열
		n = Integer.parseInt(st.nextToken()); // 행
		h = Integer.parseInt(st.nextToken());
		
		tomato = new int[n][m][h];
		check = new boolean[n][m][h];
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<m; k++) {
					tomato[j][k][i] = Integer.parseInt(st.nextToken());
					
					if(tomato[j][k][i] == 0) count++;
					if(tomato[j][k][i] == 1) {
						check[j][k][i] = true;
						q.add(new int[] {j, k, i, 0});
					}
				}
			}
		}
		
		int res = bfs();
		if(count != chk) System.out.println(-1);
		else System.out.println(res);
	}

	static int[] dx = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};
	static int bfs() {
		int cnt = 0;	
		
		while(!q.isEmpty()) {
			int[] pol = q.poll();
			
			for(int i=0; i<6; i++) {
				int nx = dx[i] + pol[0];
				int ny = dy[i] + pol[1];
				int nz = dz[i] + pol[2];
				
				if(nx < 0 || ny < 0 || nz < 0 || nx >= n || ny >=m || nz >= h) continue;
				if(tomato[nx][ny][nz] == -1 || check[nx][ny][nz]) continue;
				
				if(tomato[nx][ny][nz] == 0) chk++;
				check[nx][ny][nz] = true;
				
				q.add(new int[] {nx, ny, nz, pol[3] + 1});
				cnt = pol[3] + 1;
			}
		}
		return cnt;
	}
}
