package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class kej10799 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		Stack stack = new Stack();
		
		char now = ' ';
		char before = ' ';
		int result = 0;
		for(int i = 0; i<s.length();i++) {
			
			if(i == 0 || stack.size()==0) {
				before = s.charAt(i);
				stack.add(before);
				continue;
			}
			
			now = s.charAt(i);
			if(stack.size()==1 && before != ')') {
				if(before == '(' && now == '(') {
					stack.add(now);
				}else if(before =='(' && now ==')') {
					stack.pop();
				}
			}
			else {
				if(before == '(' && now == '(') {
					stack.add(now);
				}else if(before == ')' && now == '(') {
					stack.add(now);
				}else if(before == ')' && now == ')') {
					stack.pop();
					result += 1;
				}else if(before =='(' && now ==')') {
					stack.pop();
					result+=stack.size();
				}
			}
			before = now;
			
		}
		System.out.print(result);
	}

}
