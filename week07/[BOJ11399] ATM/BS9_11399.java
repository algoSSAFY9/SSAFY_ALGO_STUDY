package algorithm_study.week7;

import java.io.*;
import java.util.*;

public class BS9_11399 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list);
		
		int total = 0;
		for(int i=0; i<N; i++) {
			total+=list.get(i);
		}
		int ans=total;
		for(int i=N-1; i>=0; i--) {
			total-=list.get(i);
			ans=ans+total;
		}
		System.out.println(ans);
	}
}
