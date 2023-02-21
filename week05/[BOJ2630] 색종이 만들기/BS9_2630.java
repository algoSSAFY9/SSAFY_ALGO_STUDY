package algoStudy.분할정복;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이 만들기
public class BS9_2630 {
	
	static int[][] paper;
	static int blue=0, white=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		paper = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				paper[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
	}

	static void dfs(int y, int x, int n) {
		int sum=0;
		for(int i=y; i<y+n; i++) {
			for(int j=x; j<x+n; j++) {
				sum+=paper[i][j];
			}
		}
		if(sum==n*n) {
			blue++;
		}
		else if(sum==0) {
			white++;
		}
		else {
			n=n/2;
			dfs(y, x, n);
			dfs(y, x+n, n);
			dfs(y+n, x, n);
			dfs(y+n, x+n, n);
		}
	}
}
