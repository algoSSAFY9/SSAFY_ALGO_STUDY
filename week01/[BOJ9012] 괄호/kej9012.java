package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class kej9012 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		char c =' ';
		Stack<Character> stack = new Stack<>();
		
		for (int tc = 0; tc < T; tc++) {
			String s = br.readLine();
			stack.clear();
			
			for (int i = 0; i < s.length(); i++) {
				c = s.charAt(i);
				
				// '('는 stack에 넣기
				if(c =='(') {
					stack.add(c);
				}
				else if(c == ')') {
					if(stack.empty()) { // ')'가 들어왔는데 비었다? add하고 break
						stack.add(c);
						break;
					}
					stack.pop();
				}
			}
			if(stack.empty()) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			
		}
		
	}

}
