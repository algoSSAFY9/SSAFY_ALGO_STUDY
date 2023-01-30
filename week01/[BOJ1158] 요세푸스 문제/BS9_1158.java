package algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BS9_1158 {
	
	static int N, K;
	static Queue<Integer> arr = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		sb.append("<");
		
		for(int i=1; i<=N; i++) arr.add(i);
		
		int total=0, cnt=0;
		while(total!=N) {
			if(++cnt==K) {
				total++;
				cnt=0;
				if(total==1)	sb.append(arr.poll());
				else sb.append(", "+arr.poll());
			}
			else {
				arr.add(arr.poll());
			}
		}
		System.out.println(sb.append(">"));
	}
}
