package algorithm_study.week10;

import java.io.*;
import java.util.*;

public class Main {

	static int N, cnt;
	static char[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		visit = new boolean[N][N];
		
		List<Integer> cntList = new ArrayList<>();
		
		for(int i=0; i<N; i++) map[i]=br.readLine().toCharArray();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j] && map[i][j]=='1') {
					cnt=0;
					dfs(i, j);
					cntList.add(cnt);
				}
			}
		}
		
		Collections.sort(cntList);
		
		sb.append(cntList.size()).append("\n");
		for(int c : cntList) sb.append(c).append("\n");
		
		System.out.println(sb);
	}
	
	static void dfs(int y, int x) {
		visit[y][x]=true;
		if(x<N-1 && map[y][x+1]=='1' && !visit[y][x+1]) { // →
			dfs(y, x+1);
		}
		if(y<N-1 && map[y+1][x]=='1' && !visit[y+1][x]) { // ↓
			dfs(y+1, x);
		}
		if(x>0 && map[y][x-1]=='1' && !visit[y][x-1]) { // ←
			dfs(y, x-1);
		}
		if(y>0 && map[y-1][x]=='1' && !visit[y-1][x]) { // ↑
			dfs(y-1, x);
		}
		
		cnt++;
		return;
	}
}