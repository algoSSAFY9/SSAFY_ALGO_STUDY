package algorithm_study.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BS9_14889 {

	static int N, hN, min=Integer.MAX_VALUE;
	static int[][] scores;
	static int[] temp, temp2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		hN=N/2;
		
		scores=new int[N][N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				scores[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				scores[i][j]+=scores[j][i];
			}
		}
		
		temp = new int[hN];
		temp2=new int[hN];
		
		dfs(1, 1, 1);
		System.out.println(min);
	}

	static void dfs(int idx, int select, int cnt) {
		if(min==0) return;
		if(cnt==hN) {
			int sumA =0, sumB=0;
			int c1=0, c2=0;
			for(int i=0; i<N; i++) {
				if((select&1<<i)!=0) temp[c1++]=i;
				else temp2[c2++]=i;
			}
			for(int i=0; i<hN-1; i++) {
				for(int j=i+1; j<hN; j++) {
					sumA+=scores[temp[i]][temp[j]];
					sumB+=scores[temp2[i]][temp2[j]];
				}
			}
			
			min=Math.min(min, Math.abs(sumA-sumB));
			return;
		}
		if(hN-cnt>N-idx) return;
		
		for(int i=idx; i<N; i++)
			dfs(i+1, select|1<<i, cnt+1);
	}
}
