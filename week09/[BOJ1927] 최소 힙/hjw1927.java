import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class hjw1927 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if( x == 0 ) {
				int res = pq.isEmpty()? 0 : pq.poll();
				sb.append(res).append("\n");
			}
			else pq.add(x);
		}
		
		System.out.println(sb.toString());
	}

}
