package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class kej17413 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Character> stack = new ArrayDeque<>();
		String s = br.readLine();
		char c = ' ';
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '<') {	// <만났는데 스택이 존재하면
				if(stack.size()!=0) {
					while (stack.size() != 0) {
						sb.append(stack.pollLast());
					}
				}
				sb.append(s.charAt(i));
				while (true) {
					i++;
					if (s.charAt(i) == '>') {
						sb.append(s.charAt(i));
						break;
					}
					sb.append(s.charAt(i));
				}
				continue;
			}
			if (s.charAt(i) == ' ') { // 공백 만나면 거꾸로
				while (stack.size() != 0) {
					sb.append(stack.pollLast());
				}
				sb.append(" ");
				continue;
			}
			stack.add(s.charAt(i));
		}
		
		if(stack.size()!=0) {
			while(stack.size()!=0) {
				sb.append(stack.pollLast());
			}
		}
		System.out.println(sb);
	}

}
