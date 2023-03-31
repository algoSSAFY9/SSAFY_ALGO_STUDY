import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class hjw1931 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		PriorityQueue<int[] > pq = new PriorityQueue<>(new Comparator<int[] >() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
	
//		반례)
//		3
//		1 2
//		3 4
//		4 4
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {start, end});
		}
		
		int start = pq.poll()[1]; 
		int cnt = 1;
		while(!pq.isEmpty()) {
			int[] pol = pq.poll();
			if( pol[0] >= start ) {
				start = pol[1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
