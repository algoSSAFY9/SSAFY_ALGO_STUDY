package algorithm_study.그래프와순회;

import java.io.*;
import java.util.*;

public class BS9_1012 {

	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<T; tc++) {
			
			st=new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visit = new boolean[N][M];

			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}

			int cnt=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(!visit[i][j] && map[i][j]==1) {
						dfs(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}
	}
	
	static void dfs(int y, int x) {
		visit[y][x]=true;
		if(x<M-1 && map[y][x+1]==1 && !visit[y][x+1]) { // →
			dfs(y, x+1);
		}
		if(y<N-1 && map[y+1][x]==1 && !visit[y+1][x]) { // ↓
			dfs(y+1, x);
		}
		if(x>0 && map[y][x-1]==1 && !visit[y][x-1]) { // ←
			dfs(y, x-1);
		}
		if(y>0 && map[y-1][x]==1 && !visit[y-1][x]) { // ↑
			dfs(y-1, x);
		}
		
		return;
	}
}