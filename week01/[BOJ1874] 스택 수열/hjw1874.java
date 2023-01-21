import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class hjw1874 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> st = new Stack<>();
		int idx = 1, i=1;
		while(idx <= n) {
			if(!st.isEmpty() && st.peek() == arr[idx]) {
				st.pop();
				sb.append("-").append("\n");
				idx++;
			}
			else if(i <= n){
				st.add(i++);
				sb.append("+").append("\n");
			}
			else break;
			
		}
		if(i != idx) System.out.println("NO");
		else System.out.println(sb.toString());
	}

}
