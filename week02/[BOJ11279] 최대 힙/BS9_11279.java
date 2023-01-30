package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BS9_11279 {

	public static void main(String[] args) throws IOException {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x==0) {
				if(maxHeap.isEmpty()) sb.append(0+"\n");
				else sb.append(maxHeap.poll()+"\n");
			}
			else {
				maxHeap.add(x);
			}
		}
		System.out.println(sb);
	}
}
