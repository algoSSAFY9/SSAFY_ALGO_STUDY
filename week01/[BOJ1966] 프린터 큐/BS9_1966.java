package algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 난 멍청하다.
public class BS9_1966 {

	static LinkedList<int[]> q;
	static StringTokenizer st ;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			st= new StringTokenizer(br.readLine());
			
			q = new LinkedList<>();
			
			int N = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<N; i++) {
				q.add(new int[]{i, Integer.parseInt(st.nextToken())});
			}
			
			int cnt=0;
			
			while(!q.isEmpty()) {
				int[] peek = q.poll();
				boolean peek_isMax = true;
				
				for(int i=0; i<q.size(); i++) {
					if(peek[1]<q.get(i)[1]) {
						q.offer(peek);
						for(int j=0; j<i; j++)
							q.offer(q.poll());
						peek_isMax=false;
						break;
					}
				}
				if(!peek_isMax)	continue;
				
				cnt++;
				if(peek[0]==idx) break;
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}
}
