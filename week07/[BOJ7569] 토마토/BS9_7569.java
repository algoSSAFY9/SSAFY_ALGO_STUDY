package algorithm_study.week7;

import java.io.*;
import java.util.*;

public class BS9_7569 {

	static int N, M, H, cnt=0, total=0, ans=0;
	static Queue<int[]> queue = new ArrayDeque<>();
	static int[][][] pan;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		pan = new int[H][N][M];
		
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int t = Integer.parseInt(st.nextToken());
					pan[h][i][j] = t;
					if (t == 1) {
						queue.add(new int[] { h, i, j });
						cnt++;
					} else if (t == 0)
						total++;
				}
			}
		}
		
		if(total==0) { // 모두 익어있는 상태에서 시작하는경우
			System.out.println(0);
			return;
		}
		
		bfs();
		
		if(total==0) System.out.println(ans-1);
		else System.out.println(-1);
	}
	
	static void bfs() {
		
		while(!queue.isEmpty()) {
			cnt--;
			int[] cur = queue.poll();
			
			int h=cur[0], y = cur[1], x=cur[2];
			
			if(y>0 && pan[h][y-1][x]==0) {
				pan[h][y-1][x]=1;
				queue.add(new int[] {h, y-1, x});
				total--;
			}
			
			if(y<N-1 && pan[h][y+1][x]==0) {
				pan[h][y+1][x]=1;
				queue.add(new int[] {h, y+1, x});
				total--;
			}
			
			if(x>0 && pan[h][y][x-1]==0) {
				pan[h][y][x-1]=1;
				queue.add(new int[] {h, y, x-1});
				total--;
			}
			
			if(x<M-1 && pan[h][y][x+1]==0) {
				pan[h][y][x+1]=1;
				queue.add(new int[] {h, y, x+1});
				total--;
			}
			
			if(h>0 && pan[h-1][y][x]==0) {
				pan[h-1][y][x]=1;
				queue.add(new int[] {h-1, y, x});
				total--;
			}
			
			if(h<H-1 && pan[h+1][y][x]==0) {
				pan[h+1][y][x]=1;
				queue.add(new int[] {h+1, y, x});
				total--;
			}
			
			
			if(cnt==0) {
				cnt = queue.size();
				ans++;
			}
		}
	}
}
