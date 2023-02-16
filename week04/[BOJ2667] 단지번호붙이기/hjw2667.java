import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class hjw2667 {
	static int[][] arr;
	static boolean[][] chk;
	static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		chk = new boolean[n][n];
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}
		}
		
		int cnt = 0;
		ArrayList<Integer> res = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] == 1 && !chk[i][j]) {
					cnt++;
					res.add(cal(i, j));
				}
			}
		}
		Collections.sort(res);
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		for(int num : res) {
			sb.append(num).append("\n");
		}
		System.out.println(sb);
	}
	
	static int cal(int x, int y) {
		int count = 1;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		Queue<int[] > q = new LinkedList<>();
		q.add(new int[] {x, y});
		chk[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] pl = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = dx[i] + pl[0];
				int ny = dy[i] + pl[1];
				
				if(nx >=0 && ny >= 0 && nx < n && ny < n && !chk[nx][ny] && arr[nx][ny] == 1) {
					count++;
					chk[nx][ny] = true;
					q.add(new int[] {nx, ny});
				}
			}
		}
		return count;
	}
}
