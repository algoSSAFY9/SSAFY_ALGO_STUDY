package study;

import java.io.*;
import java.util.*;

public class BS9_16236 {

	static int N, count=0, ans=0;
	static int[][] space;
	static boolean[][] visit;
	static int size=2;
	static int[] loc = new int[2]; //9   y,x
	static int[] dy = {-1, 0, 0, 1};
	static int[] dx = {0, -1, 1, 0};
	static PriorityQueue<int[]> pq;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		space= new int[N][N];
		visit= new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int v = Integer.parseInt(st.nextToken());
				space[i][j]= v;
				if(v==9) {
					loc[0]=i;
					loc[1]=j;
				}
			}
		}
		
		pq = new PriorityQueue<>((s1, s2)-> {
			if(s1[0]==s2[0]) return s1[1]-s2[1];
			return s1[0]-s2[0];
		});
		
		find();
		
		System.out.println(ans);
	}
	
	static void find() { // 아기상어의 현재 위치에서 탐색 시작
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {loc[0], loc[1], 0});
		visit[loc[0]][loc[1]]=true;
		
		int flag=-1;
		pq.clear();
		
		int y, x, cnt;
		while(!queue.isEmpty()) {
			
			int[] t = queue.poll();
			y = t[0];
			x = t[1];
			cnt = t[2];
			
			if(flag!=cnt) {
				flag=cnt;
				
				if(cal(pq)) return;
				
				pq.clear();
			}
			
			pq.add(new int[] {y, x, cnt});
			
			
			for(int d=0; d<4; d++) {
				int ny = y+dy[d];
				int nx = x+dx[d];
				
				if(ny<0 || ny>=N || nx<0 || nx>=N || visit[ny][nx]) continue;
				
				visit[ny][nx]=true;
				if(space[ny][nx]>size) continue;
				
				queue.add(new int[] {ny, nx, cnt+1});
			}
		}
		cal(pq);
		return;
	}
	
	static boolean cal(PriorityQueue<int[]> pq) {
		
		while(!pq.isEmpty()) {
			int[] t = pq.poll();
			int y=t[0];
			int x=t[1];
			int cnt = t[2];
			if(space[y][x]!=0 && space[y][x]<size) {
				space[y][x]=9;
				space[loc[0]][loc[1]]=0;
				loc[0]=y; loc[1]=x;
				count++;
				if(count==size) {
					count=0;
					size++;
				}

				ans+=cnt;

				visit = new boolean[N][N];
				find();

				return true;
			}
		}
		return false;
	}
}
