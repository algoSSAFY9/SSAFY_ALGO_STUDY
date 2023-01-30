package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BS9_11286 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2)->{
			int a = Math.abs(n1);
			int b = Math.abs(n2);
			if(a==b) return n1>n2 ? 1:-1;
			return a-b;
		});
		for(int i=0; i<N; i++) {
			int n=Integer.parseInt(br.readLine());
			if(n==0) {
				if(pq.isEmpty()) sb.append(0+"\n");
				else sb.append(pq.poll()+"\n");
			}
			else pq.add(n);
		}
		System.out.println(sb);
	}
}
