package algorithm_study.week10;

import java.io.*;
import java.util.*;

public class BS9_11403 {

	static int N;
	static int[][] matrix;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb=new StringBuilder();
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				matrix[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			bfs(i);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void bfs(int idx) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(idx);
		int[] visit = new int[N];
		
		while(!q.isEmpty()) {
			int n = q.poll();
			
			for(int i=0; i<N; i++) {
				if(matrix[n][i]==0 || visit[i]==1) continue;
				
				visit[i]=1;
				q.add(i);
			}
		}
		for(int i=0; i<N; i++) sb.append(visit[i]).append(' ');
	}
}
