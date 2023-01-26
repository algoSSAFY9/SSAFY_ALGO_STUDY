import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class hjw11286 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[] > pq = new PriorityQueue<>(new Comparator<int[] >() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
		
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				int res = pq.isEmpty() ? 0 : pq.poll()[0];
				sb.append(res).append("\n");
			}
			else {
				pq.add(new int[] {x, Math.abs(x)});
			}
		}
		
		System.out.println(sb.toString());
	}

}
