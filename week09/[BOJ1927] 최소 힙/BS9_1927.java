package algorithm_study.week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BS9_1927 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int n = Integer.parseInt(br.readLine());
		
		int t;
		for(int i=0; i<n; i++) {
			t = Integer.parseInt(br.readLine());
			if(t==0) {
				if(pq.isEmpty()) sb.append("0\n");
				else sb.append(pq.poll()).append("\n");
			}
			else {
				pq.add(t);
			}
		}
		System.out.println(sb);
	}
}
