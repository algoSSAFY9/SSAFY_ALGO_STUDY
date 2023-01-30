package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BS9_10799 {

	static Stack<Character> stack = new Stack<>();
	static ArrayList<Integer> cnt_razer = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String arr = br.readLine();
		
		boolean isRazer = true;
		int result=0;
		
		for(int i=0; i<arr.length(); i++) {
			char c = arr.charAt(i);
			if(c==')') {
				if(isRazer) { 		// ')'이고 razer인 경우
					isRazer=false;
					stack.pop();
					cnt_razer.remove(stack.size());
					if(stack.size()>0)
						cnt_razer.set(stack.size()-1, cnt_razer.get(stack.size()-1)+1);
				}
				else {				// ')'이고 razer가 아닌 경우
					stack.pop();
					int cnt = cnt_razer.get(stack.size());
					result+=cnt+1;
					if(stack.size()>0)
						cnt_razer.set(stack.size()-1, cnt_razer.get(stack.size()-1)+cnt);
					cnt_razer.remove(stack.size());
				}
			}
			else { 					// '(' 인 경우
				isRazer = true;
				stack.push(c);
				cnt_razer.add(0);
			}
		}
		System.out.println(result);
	}
}
