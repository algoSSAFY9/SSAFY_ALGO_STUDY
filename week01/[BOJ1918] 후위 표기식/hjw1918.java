import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class hjw1918 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String Line = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<Line.length(); i++) {
			char ch = Line.charAt(i); 
			
			if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				while(!stack.isEmpty() && priority(stack.peek()) >= priority(ch)) {
					sb.append(stack.pop());
				}
				stack.add(ch);
			}
			else if(ch == '(') stack.add('(');
			else if(ch == ')') {
				while(stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
			}
			else sb.append(ch);
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
		
	}
	static int priority(char x) {
		if(x == '+' || x =='-') return 1;
		else if(x == '*' || x == '/') return 2;
		else return 0;
	}
}
