package algorithm_study.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BS9_1913 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int find = Integer.parseInt(br.readLine());
		
		int[][] snail = new int[N][N];
		snail[N/2][N/2]=1;
		
		int cnt=2;
		int resultX = N/2, resultY=N/2+1;
		for(int d=N/2-1; d>=0; d--) {
			for(int i=d+1; i<N-d; i++) {
				if(cnt==find) {resultX=d+1; resultY=i+1;}
				snail[d][i]=cnt++;
			}
			for(int i=d+1; i<N-d; i++) {
				if(cnt==find) {resultX=i+1; resultY=N-d;}
				snail[i][N-d-1]=cnt++;
			}
			for(int i=N-d-2; i>d-1; i--) {
				if(cnt==find) {resultX=N-d; resultY=i+1;}
				snail[N-d-1][i]=cnt++;
			}
			for(int i=N-d-2; i>d-1; i--) {
				if(cnt==find) {resultX=i+1; resultY=d+1;}
				snail[i][d]=cnt++;
			}
		}
		for(int[] s : snail) {
			for(int i=0; i<N; i++)
				sb.append(s[i]).append(" ");
			sb.append("\n");
		}
		sb.append(resultX+" "+resultY);
		System.out.println(sb);
	}
}
