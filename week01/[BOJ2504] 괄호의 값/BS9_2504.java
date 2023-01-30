package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BS9_2504 {

	static Stack<Character> stack = new Stack<>();
	static ArrayList<Integer> temp = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int result=0;
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c==')') {
				if(!stack.isEmpty() && stack.pop()=='(') {
					if(stack.isEmpty()) result+=2*temp.get(0);
					else temp.set(stack.size()-1, temp.get(stack.size()-1) + ((temp.get(stack.size())==0)?2:2*temp.get(stack.size())));
					temp.remove(stack.size());
				}
				else {result=0; break;}
			}
			else if(c==']') {
				if(!stack.isEmpty() && stack.pop()=='[') {
					if(stack.isEmpty()) result+=3*((temp.get(0)==0)?1:temp.get(0));
					else temp.set(stack.size()-1, temp.get(stack.size()-1) + ((temp.get(stack.size())==0)?3:3*temp.get(stack.size())));
					temp.remove(stack.size());
				}
				else {result=0; break;}
			}
			else {
				stack.push(c);
				temp.add(1);
			}
		}
		System.out.println(result);
	}
}
