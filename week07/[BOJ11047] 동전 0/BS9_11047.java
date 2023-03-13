package algorithm_study.week7;

import java.io.*;
import java.util.*;

public class BS9_11047 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int ans=0;
		int[] list = new int[N];
		
		for(int i=N-1; i>=0; i--) list[i]=Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			if(K/list[i]>0) {
				int t = K/list[i];
				K-=t*list[i];
				ans+=t;
			}
		}
		System.out.println(ans);
	}
}
