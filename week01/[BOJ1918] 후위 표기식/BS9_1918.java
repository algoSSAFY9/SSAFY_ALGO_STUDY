package algorithm_study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 124ms
public class BS9_1918 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		Deque<Character> stack = new ArrayDeque<>();
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if('A'<=c) {
				sb.append(c);
			}
			else if(c=='(') {
				stack.push(c);
			}
			else if(c==')') {
				while(stack.peek()!='(') {
					sb.append(stack.pop());
				}
				stack.pop();
			}
			else {
				while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                    sb.append(stack.pop());
                }
				
				stack.push(c);
			}
		}
		
		while(!stack.isEmpty())
			sb.append(stack.pop());
		System.out.println(sb);
	}
	
    public static int priority(char operator){

        if(operator=='(' || operator==')'){
            return 0;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return -1;
    }
}
