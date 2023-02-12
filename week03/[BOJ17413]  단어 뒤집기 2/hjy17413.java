package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class hjy17413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		boolean open = false;
		
		for (int i = 0; i < str.length(); i++) {
			
			// '<' 만난 경우
			if(str.charAt(i) == '<') {
				open = true;
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append("<");
			}

			// '>' 만난 경우
			else if(str.charAt(i) == '>'){
				open = false;
				sb.append(">");
			}
			
			// 괄호가 열린 상태인 경우
			else if(open) {
				sb.append(str.charAt(i));
			}
			
			// 괄호가 닫혀 있는 경우
			else if(!open) {
				// 공백 만나면 다 출력
				if(str.charAt(i) == ' ') {
					while (!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(" ");
				}
				else {
					stack.push(str.charAt(i));
				}
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.print(sb);
	}
}
