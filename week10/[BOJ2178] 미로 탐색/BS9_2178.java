package algorithm_study.week10;

import java.io.*;
import java.util.*;

public class BS9_2178 {

	static int N, M;
	static int[][] miro;
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		miro = new int[N+2][M+2];
		
		for(int i=1; i<=N; i++) {
			String str = br.readLine();
			for(int j=1; j<=M; j++) {
				miro[i][j] = str.charAt(j-1)-'0';
			}
		}
		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {1,1,1});
		miro[1][1] = 0;
		
		while(!q.isEmpty()) {
			int[] t = q.poll();
			
			if(t[0]==N && t[1]==M) return t[2];
			
			for(int d=0; d<4; d++) {
				int ny = t[0] + dy[d];
				int nx = t[1] + dx[d];
				
				if(miro[ny][nx]==0) continue;
				miro[ny][nx] = 0;
				q.add(new int[] {ny, nx, t[2]+1});
			}
			
		}
		return 0;
	}
}
