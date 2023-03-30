package algorithm_study.week10;

import java.io.*;
import java.util.*;

public class BS9_1931 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;

		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2)->{
			if(n1[1]==n2[1]) return n1[0]-n2[0];
			return n1[1]-n2[1];
		});
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			pq.add(new int[] {s, e});
		}
		
		int end = 0, cnt=0;
		while(!pq.isEmpty()) {
			int[] t = pq.poll();
			int s = t[0];
			int e = t[1];
			
			if(end<=s) {
				cnt++;
				end=e;
			}
		}
		System.out.println(cnt);
	}
}
