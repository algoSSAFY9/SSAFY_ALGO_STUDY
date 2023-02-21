package algoStudy.분할정복;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BS9_1780 {

	static int mCnt=0, pCnt=0, zCnt=0;
	static int[][] paper;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
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
		
		System.out.println(mCnt);
		System.out.println(zCnt);
		System.out.println(pCnt);
	}
	
	static void dfs(int y, int x, int n) {
		int c = paper[y][x];
		
		for(int ny=y; ny<y+n; ny++) {
			for(int nx=x; nx<x+n; nx++) {
				if(paper[ny][nx]!=c) {
					n=n/3;
					for(int i=0; i<3; i++) {
						for(int j=0; j<3; j++) {
							dfs(y+(i*n), x+(j*n), n);
						}
					}
					return;
				}
			}
		}
		
		if(c==-1) mCnt++;
		else if(c==0) zCnt++;
		else pCnt++;
	}
}
