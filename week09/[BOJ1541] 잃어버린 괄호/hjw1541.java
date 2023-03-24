import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class hjw1541 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		Deque<String> q = new ArrayDeque<>();
		
		String[] num = line.split("\\+|\\-");
		int idx = 1;
		q.add(num[0]);
		for(int i=0; i<line.length(); i++) {
			if(line.charAt(i) == '-') {
				q.add("-");
				q.add(num[idx++]);
			}
			else if(line.charAt(i) == '+') {
				int x = Integer.parseInt(q.pollLast()) + Integer.parseInt(num[idx++]);
				q.add(x + "");
			}
		}

		int n = 0;
		while(!q.isEmpty()) {
			if(q.size() == 1) {
				System.out.println(q.poll());
				break;
			}
			
			String st = q.poll();
			
			if(st.equals("-")) {
				n = n - Integer.parseInt(q.poll());
				q.add(n + "");
			}
			else n = Integer.parseInt(st);
		}
	}

}
