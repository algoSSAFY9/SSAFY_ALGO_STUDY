import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 1: 이동 가능
 * 0: 이동 불가
 */

public class hjy2178 {
	static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    
	static int n;	// 행
	static int m;	// 열
	static int[][] map;
	static boolean[][] isVisited;
	
	static int cur_r, cur_c;

	static Queue<Poin> que = new LinkedList<>();
	
	// 방문 위치 좌표
	static class Poin {
		int r;
		int c;

		public Poin(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        
        for (int r = 0; r < n; r++) {
        	String str = br.readLine();
			for (int c = 0; c < m; c++) {
				map[r][c] = str.charAt(c) - '0'; 
			}
		}
        
        isVisited = new boolean[n][m];
        bfs(0,0);

        System.out.println(map[n-1][m-1]);
        
	}
	
	static void bfs(int r, int c) {
		que.offer(new Poin(r, c)); 
		isVisited[r][c] = true;

		while( !que.isEmpty() ) {
			Poin point = que.poll();	// 최근 방문 위치 좌표
			for(int i = 0; i < 4; i++) {
				cur_r = point.r + dr[i];
				cur_c = point.c + dc[i];

				if(cur_r >= 0 && cur_r < n && cur_c >= 0 && cur_c < m && isVisited[cur_r][cur_c] == false && map[cur_r][cur_c] == 1) {                 
					que.offer(new Poin(cur_r, cur_c));
					isVisited[cur_r][cur_c] = true;	

					// 현위치 값  = 누적 방문 수  + 1
					map[cur_r][cur_c] = map[point.r][point.c] + 1;
					
					// 목적지 방문해 누적 방문 수 입력 후 return
					if(isVisited[n-1][m-1] == true) {
						return;
					}

				}
			}	
		}
	}
}
