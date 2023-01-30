package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BS9_2346 {

	public static void main(String[] args) throws IOException {
		Deque<int[]> dq = new ArrayDeque<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++)
			dq.add(new int[] {i, Integer.parseInt(st.nextToken())});
		
		int[] b1=dq.pollFirst();
		sb.append(b1[0]+" "); // 풍선 번호
		int cnt = b1[1]; // 풍선 안의 숫자
		
		while(!dq.isEmpty()) {
			if(cnt>0) {
				
				for(int i=1; i<cnt; i++) {
					dq.addLast(dq.pollFirst());
				}
				int[] b = dq.pollFirst();
				sb.append(b[0]+" ");
				cnt=b[1];
				
			}
			else {
				
				for(int i=1; i<Math.abs(cnt); i++) {
					dq.addFirst(dq.pollLast());
				}
				int[] b = dq.pollLast();
				sb.append(b[0]+" ");
				cnt=b[1];
				
			}
		}
		System.out.println(sb);
	}
}
