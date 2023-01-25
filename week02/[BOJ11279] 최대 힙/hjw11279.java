import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class hjw11279 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
			
		});
		
		for(int i=0; i<n; i++) {
			int check = Integer.parseInt(br.readLine());
			
			if(check == 0) {
				sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
			}
			else {
				pq.add(check);
			}
		}
		System.out.println(sb.toString());
	}

}
