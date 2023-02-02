package 백준문제;
// 132ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class kej1918 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i<s.length();i++) {
			char a = s.charAt(i);
			if(a == '(') stack.add(a);				// ( 가 들어오면 stack.add
			else if(a == ')') {
				while(stack.peek()!='(') {			// ) 가 들어오면 ( 나올 때 까지 pop
					sb.append(stack.pop());
				}
				stack.pop();
			}
			else if(a == '+' || a == '-') {			// + - 들어오면 ( 만나기 전까지 pop하고 add
					while(true) {
						if(stack.size()== 0 || stack.peek()=='(') break;
						sb.append(stack.pop());
					}
				stack.add(a);
			}
			else if(a == '*' || a == '/') {			// * / 들어오면 ( 만나기 전까지 pop 단, +나 - 만나면 멈추고 add
				while(true) {
					if(stack.size()== 0 || stack.peek()=='(') break;
					if(stack.peek() == '+' || stack.peek() == '-') break; //나보다 우선순위 낮은거 만나면 stack.add
					else sb.append(stack.pop());	// 우선순위 같으면 stack.pop
					}
				stack.add(a);
			}
			else sb.append(a);
			
		}
		
		while(stack.size()!=0){				// 스택에 남은거 pop
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
		
		
	}

}
