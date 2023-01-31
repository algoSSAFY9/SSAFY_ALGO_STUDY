import java.io.*;
import java.util.*;

public class BS9_2493 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Deque<int[]> stack = new ArrayDeque<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			int h = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) {
				if(stack.peekLast()[1]<h) stack.pollLast();
				else {
					sb.append(stack.peekLast()[0]+" ");
					break;
				}
			}
			if(stack.isEmpty()) sb.append(0+" ");
			
			stack.addLast(new int[] {i, h});
		}
		System.out.println(sb);
	}
}
