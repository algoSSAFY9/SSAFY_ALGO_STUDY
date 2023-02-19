import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class hjw7576 {
	static int[][] arr;
	static boolean[][] check;
	static int n, m, cnt = 0, chk = 0;
	static Queue<int[] > q = new LinkedList<int[]>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); // 열
		n = Integer.parseInt(st.nextToken()); // 행
		
		arr = new int[n][m];
		check = new boolean[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 0) cnt++;
				else if(arr[i][j] == 1) {
					check[i][j] = true;
					q.add(new int[] {i, j, 0});
				}
			}
		}
		int res = cal();

		if(cnt != chk) System.out.println(-1);
		else System.out.println(res);
		
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int cal() {
		int cnt = 0;

		while(!q.isEmpty()) {
			int[] pol = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = pol[0] + dx[i];
				int ny = pol[1] + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == -1 || check[nx][ny]) continue;
				check[nx][ny] = true;
				
				if(arr[nx][ny] == 0) chk++;
				
				arr[nx][ny] = 1;
				q.add(new int[] {nx, ny, pol[2] + 1});
				cnt = pol[2] + 1;
			}
		}
		return cnt;
	}
}
