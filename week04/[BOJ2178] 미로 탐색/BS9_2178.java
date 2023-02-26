package algorithm_study.그래프와순회;

import java.io.*;
import java.util.*;

public class BS9_2178 {

	static int N, M;
	static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int i=0; i<N; i++) map[i]=br.readLine().toCharArray();
		
		dfs();
	}

	static void dfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {0, 0, 1});
		map[0][0]='0';
		
		while(!queue.isEmpty()) {
			int[] t = queue.poll();
			
			int y = t[0];
			int x = t[1];
			int cnt = t[2];
			
			if(y==N-1 && x==M-1) {
				System.out.println(cnt);
				break;
			}
			
			if(y>0 && map[y-1][x]=='1') {
				map[y-1][x]='0';
				queue.add(new int[] {y-1, x, cnt+1});
			}
			if(x<M-1 && map[y][x+1]=='1') {
				map[y][x+1]='0';
				queue.add(new int[] {y, x+1, cnt+1});
			}
			if(y<N-1 && map[y+1][x]=='1') {
				map[y+1][x]='0';
				queue.add(new int[] {y+1, x, cnt+1});
			}
			if(x>0 && map[y][x-1]=='1') {
				map[y][x-1]='0';
				queue.add(new int[] {y, x-1, cnt+1});
			}
		}
	}
}
