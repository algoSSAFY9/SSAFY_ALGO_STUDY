package algoStudy.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BS9_22858 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] D = new int[N]; // index
		int[] P = new int[N]; // pre
		int[] S = new int[N]; // result
		
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			S[i]=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			D[i]=Integer.parseInt(st.nextToken())-1;
		
		for(int i=0; i<K; i++) {
			for(int j=0; j<N; j++) {
				P[D[j]]=S[j];
			}
			S=P.clone();
		}
		for(int j=0; j<N; j++) {
			P[D[j]]=S[j];
		}
		
		// 이렇게 분리하니까 오히려 메모리랑 시간이 늘어남.
//		for(int i=0; i<K-1; i++) {
//			for(int j=0; j<N; j++) {
//				P[D[j]]=S[j];
//			}
//			S=P.clone();
//		}
//		for(int j=0; j<N; j++) {
//			P[D[j]]=S[j];
//		}
		
		for(int n : P) {
			sb.append(n).append(" ");
		}
		System.out.println(sb);
	}
}
