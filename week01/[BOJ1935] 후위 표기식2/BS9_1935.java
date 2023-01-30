package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 후위 표기식2
public class BS9_1935 {

	static int N;
	static Stack<Double> stack = new Stack<>();
	static int[] operand = new int[26];
	static double b, a;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		for(int i=0; i<N; i++) {
			operand[i]=Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			switch(c) {
			case('+'):{
				b= stack.pop();
				a= stack.pop();
				stack.push(a+b);
				break;
			}
			case('-'):{
				b= stack.pop();
				a= stack.pop();
				stack.push(a-b);
				break;
			}
			case('*'):{
				b= stack.pop();
				a= stack.pop();
				stack.push(a*b);
				break;
			}
			case('/'):{
				b= stack.pop();
				a= stack.pop();
				stack.push(a/b);
				break;
			}
			default:{
				stack.push((double)operand[c-'A']);
			}
			}
		}
		System.out.printf("%.2f\n",stack.pop());
	}
}
