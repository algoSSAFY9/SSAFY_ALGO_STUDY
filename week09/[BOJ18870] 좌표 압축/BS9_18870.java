package algorithm_study.week9;

import java.io.*;
import java.util.*;

public class BS9_18870 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> x = new PriorityQueue<>((x1, x2)->x1[0]-x2[0]);
		
		int[] ans = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			x.add(new int[] {Integer.parseInt(st.nextToken()), i});
		}
		
		int[] pre = x.poll();
		int pre_x = pre[0];
		int in = 0;
		ans[pre[1]]=in;
		
		for(int i=1; i<N; i++) {
			int[] t = x.poll();
			if(t[0]==pre_x) {
				ans[t[1]] = in;
			}
			else {
				in++;
				ans[t[1]] = in;
				pre_x=t[0];
			}
		}
		for(int i=0; i<N; i++) sb.append(ans[i]).append(" ");
		System.out.println(sb);
	}
}
