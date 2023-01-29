import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class hjy10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		String str = br.readLine();
		
		int rst = 0;	// 막대 조각 수
		
		for(int i = 0; i < str.length(); i++) {
			// '('인 경우 : 막대 개수 증가
			if(str.charAt(i) == '(') {
				stack.push(1);
			}
			// ')'인 경우 : 레이저인지 검사
			else { 
				stack.pop();
				// 이전 값이 '('인 경우 : 레이저 
				if(str.charAt(i - 1) == '(') {
					rst += stack.size();	// 막대 개수만큼 막대 조각 증가
				}
				// 레이저 아님
				else {
					rst += 1;	// 막대 길이 끝남
				}
			}
		}
		System.out.println(rst);
	}

}
