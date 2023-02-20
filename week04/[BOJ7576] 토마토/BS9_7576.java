package algoStudy.그래프와순회;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BS9_7576 {

	static int N, M, cnt=0, total=0, ans=0;
	static Queue<int[]> queue = new ArrayDeque<>();
	static int[][] pan;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		pan = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int t = Integer.parseInt(st.nextToken());
				pan[i][j]=t;
				if(t==1) {
					queue.add(new int[] {i, j});
					cnt++;
				}
				else if(t==0) total++;
			}
		}
		
		if(total==0) { // 모두 익어있는 상태에서 시작하는경우
			System.out.println(0);
			return;
		}
		
		bfs();
		
		if(total==0)
			System.out.println(ans-1);
		else
			System.out.println(-1);
	}
	
	static void bfs() {
		
		while(!queue.isEmpty()) {
			cnt--;
			int[] cur = queue.poll();
			
			int y = cur[0], x=cur[1];
			
			if(y>0 && pan[y-1][x]==0) {
				pan[y-1][x]=1;
				queue.add(new int[] {y-1, x});
				total--;
			}
			
			if(y<N-1 && pan[y+1][x]==0) {
				pan[y+1][x]=1;
				queue.add(new int[] {y+1, x});
				total--;
			}
			
			if(x>0 && pan[y][x-1]==0) {
				pan[y][x-1]=1;
				queue.add(new int[] {y, x-1});
				total--;
			}
			
			if(x<M-1 && pan[y][x+1]==0) {
				pan[y][x+1]=1;
				queue.add(new int[] {y, x+1});
				total--;
			}
			
			if(cnt==0) {
				cnt = queue.size();
				ans++;
			}
		}
	}
}
