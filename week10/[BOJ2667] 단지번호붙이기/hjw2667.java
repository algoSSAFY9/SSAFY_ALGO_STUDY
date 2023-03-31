import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class hjw2667 {
	static int[][] map;
	static boolean[][] chk;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		chk = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					arr.add(cal(i, j));
				}
			}
		}
		
		Collections.sort(arr);
		StringBuilder sb = new StringBuilder();
		
		sb.append(arr.size()).append("\n");
		for(int i=0; i<arr.size(); i++) {
			sb.append(arr.get(i)).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int cal(int x, int y) {
		Deque<int[] > dq = new ArrayDeque<int[]>();
		dq.add(new int[] {x, y});
		
		map[x][y] = 0;
		int cnt = 1;
		while(!dq.isEmpty()) {
			int[] pol = dq.poll();
			
			for(int i=0; i<4; i++) {
				int nx = pol[0] + dx[i];
				int ny = pol[1] + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 0) continue;
				dq.add(new int[] {nx, ny});
				cnt++;
				map[nx][ny] = 0;
			}
		}
		return cnt;
	}
}
