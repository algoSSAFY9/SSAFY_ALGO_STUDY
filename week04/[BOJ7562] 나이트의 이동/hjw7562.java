import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class hjw7562 {
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int i = Integer.parseInt(br.readLine());
			
			arr = new int[i][i];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			sb.append(cal(startX, startY, endX, endY, i)).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	static int cal(int sx, int sy, int ex, int ey, int size) {
		int[] dx = {2, 2, 1, 1, -1, -1, -2, -2};
		int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};
		
		boolean[][] check = new boolean[size][size];
		check[sx][sy] = true;
		
		Queue<int[] > q = new LinkedList<int[]>();
		q.add(new int[] {sx, sy, 0});
		while(!q.isEmpty()) {
			int[] pol = q.poll();
			
			for(int i=0; i<8; i++) {
				int nx = pol[0] + dx[i];
				int ny = pol[1] + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= size || ny >= size || check[nx][ny]) continue;
				if(nx == ex && ny == ey) {
					return pol[2] + 1;
				}
				
				check[nx][ny] = true;
				q.add(new int[] {nx, ny, pol[2] + 1});
			}
		}	
		return 0;
	}
}
