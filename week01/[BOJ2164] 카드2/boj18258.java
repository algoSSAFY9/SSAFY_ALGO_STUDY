import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj18258 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<>();
		int back = 0;
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			
			if(line.equals("pop")) {
				if(q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(q.poll()).append("\n");
			}
			else if(line.equals("size")) {
				sb.append(q.size()).append("\n");
			}
			else if(line.equals("empty")) {
				if(q.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}
			else if(line.equals("front")) {
				if(q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(q.peek()).append("\n");
			}
			else if(line.equals("back")) {
				if(q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(back).append("\n");
			}
			else {
				String[] l = line.split(" ");
				back = Integer.parseInt(l[1]);
				q.add(back);
			}
		}
		System.out.println(sb.toString());
	}

}