package algorithm_study.week10;

import java.io.*;
import java.util.*;

public class BS9_1389 {

	static int N, M;
	static int[][] matrix, ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		matrix = new int[N+1][N+1];
		ans = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			matrix[n1][n2]=1;
			matrix[n2][n1]=1;
		}
		
		for(int i=1; i<=N; i++) {
			bfs(i);
		}
		
		for(int i=1; i<N; i++) { // \ 축 대칭
			for(int j=i+1; j<=N; j++) {
				ans[j][i] = ans[i][j];
			}
		}
		
		int min=Integer.MAX_VALUE, idx=0;
		for(int i=1; i<=N; i++) { // 최소값 찾기
			int sum=0;
			for(int j=1; j<=N; j++) {
				sum+=ans[i][j];
			}
			if(min>sum) {
				min=sum;
				idx=i;
			}
		}
		
		System.out.println(idx);
	}

	static void bfs(int s) {
		int[] visit = new int[N+1];
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {s, 0});
		visit[s]=1;
		
		while(!q.isEmpty()) {
			int[] n = q.poll();
			int idx = n[0];
			int cnt = n[1];
			
			ans[s][idx]=cnt;
			
			if(cnt==N) break;
			
			for(int i=1; i<=N; i++) {
				if(matrix[idx][i]==1 && visit[i]!=1) {
					visit[i]=1;
					q.add(new int[] {i, cnt+1});
				}
			}
		}
	}
	
}
