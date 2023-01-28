import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class hjw22942 {
	static boolean chk = false;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[] > pq = new PriorityQueue<int[]>( new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) chk = true; 
				return o1[1] - o2[1];
			}
		});
		
		if(chk) System.out.println("NO");
		
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			pq.add(new int[] {x, x-r});
			pq.add(new int[] {x, x+r});
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		while(!pq.isEmpty()) {
			if(stack.isEmpty()) {
				stack.add(pq.poll()[0]);
			}
			else {
				int num = pq.poll()[0];
				if(num == stack.peek()) {
					stack.pop();
				}
				else stack.add(num); 
			}
		}
		
		if(stack.isEmpty()) System.out.println("YES");
		else System.out.println("NO");
	}

}
