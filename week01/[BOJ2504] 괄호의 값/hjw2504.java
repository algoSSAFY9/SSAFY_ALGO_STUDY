import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class hjw2504 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String Line = br.readLine();
		
		Stack<Character> st = new Stack<>();
		Stack<Integer> intSt = new Stack<>();
		
		int res = 0;
		for(int i=0; i<Line.length(); i++) {
			char ch = Line.charAt(i);
			
			if(ch == '(' || ch == '[') st.add(ch);
			else if(ch == ')') {
				if(st.isEmpty() || (st.peek() != '(' && st.peek() != 'b')) {
					System.out.println(0);
					System.exit(0);
				}
				else if(st.peek() == '('){
					st.pop();
					if(!st.isEmpty() && st.peek() == 'b') { // 감싸는 문자가 이미 있는 경우 ex) x()
						intSt.add(intSt.pop() + 2);
					}
					else{
						intSt.add(2);
						st.add('b');
					}
				}
				else{ // ( 보다 문자가 먼저 있는 경우 ex) x)
					st.pop();
					if(!st.isEmpty()) {
						char p = st.pop();
						if(p == 'b') {
							intSt.add(intSt.pop() + intSt.pop());
							st.pop();
						}
						else if(p =='(') intSt.add(intSt.pop() * 2);
						else {
							System.out.println(0);
							System.exit(0);
						}
						if(!st.isEmpty() && st.peek() == 'b') {
							intSt.add(intSt.pop() + intSt.pop());
						}
						else st.add('b');
					}
					else {
						System.out.println(0);
						System.exit(0);
					}
				}
			}
			else if(ch == ']'){
				if(st.isEmpty() || (st.peek() != '[' && st.peek() != 'b')) {
					System.out.println(0);
					System.exit(0);
				}
				else if(st.peek() == '['){
					st.pop();
					if(!st.isEmpty() && st.peek() == 'b') {
						intSt.add(intSt.pop() + 3);
					}
					else{
						intSt.add(3);
						st.add('b');
					}
				}
				else {
					st.pop();
					if(!st.isEmpty()) {
						char p = st.pop();
						if(p == 'b') {
							intSt.add(intSt.pop() + intSt.pop());
							st.pop();
						}
						else if(p =='[') intSt.add(intSt.pop() * 3);
						else {
							System.out.println(0);
							System.exit(0);
						}
						if(!st.isEmpty() && st.peek() == 'b') {
							intSt.add(intSt.pop() + intSt.pop());
						}
						else st.add('b');
					}
					else {
						System.out.println(0);
						System.exit(0);
					}
				}
			}
		}
		res = (intSt.isEmpty() || st.size() > 1) ? 0 : intSt.pop();
		System.out.println(res);
	}
	
}
