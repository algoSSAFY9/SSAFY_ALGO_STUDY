package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class kej2493 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int check = 0;
		int result = 0;
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		for(int i = 1; i < n+1; i++) {
			check = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {
				if(stack.peek()[1] >=check) {
					sb.append(stack.peek()[0]).append(" ");
					stack.push(new int[]{i,check});
					break;
				}
				else stack.pop();
			}
			
			if(stack.size()==0) {
				sb.append("0 ");
				stack.push(new int[]{i,check});
			}
			
		}
		System.out.print(sb);
	}

}
