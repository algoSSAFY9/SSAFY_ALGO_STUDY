package algorithm_study.week9;

import java.io.*;
import java.util.*;

public class BS9_11724 {

	static int N, M;
	static int[] visit;
	static int[][] matrix;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new  StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		matrix = new int[N+1][N+1];
		visit = new int[N+1];
		for(int i=0; i<M; i++) {
			st = new  StringTokenizer(br.readLine());
			int u =Integer.parseInt(st.nextToken());
			int v =Integer.parseInt(st.nextToken());
			
			matrix[u][v]=1;
			matrix[v][u]=1;
		}
		
		int ans=0;
		for(int i=1; i<=N; i++) {
			if(visit[i]==0) {
				ans++;
				dfs(i);
			}
		}
		System.out.println(ans);
	}
	static void dfs(int s) {
		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.add(s);
		visit[s]=1;
		
		while(!queue.isEmpty()) {
			int t = queue.poll();
			
			for(int i=1; i<=N; i++) {
				if(matrix[t][i]==1 && visit[i]==0) {
					queue.add(i);
					visit[i]=1;
				}
			}
		}
	}
}
