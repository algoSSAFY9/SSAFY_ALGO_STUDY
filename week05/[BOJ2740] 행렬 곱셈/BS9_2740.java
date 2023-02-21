package algorithm_study.분할정복;

import java.io.*;
import java.util.*;

public class BS9_2740 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				A[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		int K = Integer.parseInt(st.nextToken());
		
		int[][] B = new int[M][K];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<K; j++) {
				B[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
//		int[][] AB = new int[N][K];
//		
//		for(int i=0; i<N; i++) {
//			for(int k=0; k<K; k++) {
//				int sum=0;
//				for(int j=0; j<M; j++) {
//					sum+=A[i][j]*B[j][k];
//				}
//				AB[i][k]=sum;
//			}
//		}
//		
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<K; j++) {
//				sb.append(AB[i][j]).append(" ");
//			}
//			sb.append("\n");
//		}
		
		for(int i=0; i<N; i++) {
			for(int k=0; k<K; k++) {
				int sum=0;
				for(int j=0; j<M; j++) {
					sum+=A[i][j]*B[j][k];
				}
				sb.append(sum).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
