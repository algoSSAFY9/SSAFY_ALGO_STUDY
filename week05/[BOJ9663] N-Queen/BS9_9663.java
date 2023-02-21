package algoStudy.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BS9_9663 {

	static int count=0 ,N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int[][] cnt = new int[4][];
		cnt[0] = new int[N];
		cnt[1] = new int[N];
		cnt[2] = new int[2*N-1]; // ↗  
		cnt[3] = new int[2*N-1]; // ↘
		
		dfs(0, cnt);
		
		
		System.out.println(count);
	}

	static void dfs(int n, int[][] select) {
		if(n==N) {
			count++;
			return;
		}
		
		for(int j=0; j<N; j++) {
			if(select[0][n]!=0 || select[1][j]!=0 || select[2][N-n+j-1]!=0 || select[3][n+j]!=0) {
				continue;
			}
			else {
				select[0][n]=1;
				select[1][j]=1;
				select[2][N-n+j-1]=1;
				select[3][n+j]=1;
				select[3][n+j]=1;
				dfs(n+1, select);
				select[0][n]=0;
				select[1][j]=0;
				select[2][N-n+j-1]=0;
				select[3][n+j]=0;
			}
		}
	}
}
