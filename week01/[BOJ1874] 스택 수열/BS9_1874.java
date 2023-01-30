package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BS9_1874 {

	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) arr[i]=Integer.parseInt(br.readLine());
		
		int idx=0;
		
		for(int i=1; i<=n; i++) {
			stack.push(i);
			sb.append("+\n");
			if(stack.peek()<arr[idx]) continue;
			else {
				while(!stack.isEmpty()) {
					if(stack.peek()==arr[idx]) {
						idx++;
						stack.pop();
						sb.append("-\n");
					}
					else if(stack.peek()>arr[idx]) {
						sb = new StringBuilder();
						sb.append("NO");
						break;
					}
					else break;
				}
			}
		}
		System.out.println(sb);
	}
}
