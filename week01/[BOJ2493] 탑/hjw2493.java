import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class hjw2493 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		Stack<int[] > stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) {
				if(stack.peek()[1] > num) {
					sb.append(stack.peek()[0]).append(" ");
					break;
				}
				else {
					stack.pop();
				}
			}
			if(stack.isEmpty()) sb.append(0).append(" ");
			stack.add(new int[] {i, num});
		}

		System.out.println(sb.toString());

	}

}
