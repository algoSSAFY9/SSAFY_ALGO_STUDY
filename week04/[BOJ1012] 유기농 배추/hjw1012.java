import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class hjw1012 {
	static boolean[][] chk;
	static int[][] arr;
	static int n, m;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			arr = new int[m][n];
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[x][y] = 1;
			}
			
			int cnt = 0;
			chk = new boolean[m][n];
			
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					if(arr[i][j] == 1 && !chk[i][j]) {
						chk[i][j] = true;
						cnt++;
						cal(i, j);
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	static void cal(int x, int y) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		Queue<int[] > q = new LinkedList<>();
		q.add(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] pl = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = pl[0] + dx[i];
				int ny = pl[1] + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < m && ny < n && arr[nx][ny] == 1 && !chk[nx][ny]) {
					chk[nx][ny] = true;
					q.add(new int[] {nx, ny});
				}
			}
		}
	}
}
