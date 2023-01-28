import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class hjy9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());	// 명령의 수
		
        // Stack 객체 생성.
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();		// 한줄씩 읽어옴
			int len = str.length();
			
			// 한 문자씩 끊어서 비교
			for(int j=0; j < len; j++) {
				// "("
				if(str.charAt(j) == '(') {
					stack.push(str.charAt(j));
				}
				// ")"
				else {		
					if(stack.empty()) {		// 스택이 비어있을 경우 케이스 종료
						stack.push('N');
						break;
					}
					else {		// 스택에 "("가 있는 경우
						stack.pop();
					}
				}
			}
			if(stack.empty()) {
				bw.write("YES\n");
			}
			else {
				bw.write("NO\n");
			}
			stack.clear();
		}	
		bw.flush();
		bw.close();		
		br.close();
	}

}