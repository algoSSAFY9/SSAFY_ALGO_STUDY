import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class hjy1935 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// 피연산자 개수
		Stack<Double> result = new Stack<>();	// 피연산자, 연산결과 저장 스택
		int[] nums = new int[N];	// 피연산자 배열
		String postfix = br.readLine();	// 후위 표기식
		
		
		// 피연산자 저장
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		// 후위 표기식 스택에 저장
		for(int j = 0; j < postfix.length(); j++) {
			char c = postfix.charAt(j);
			// 피연산자인 경우
			if('A' <= c && c <= 'Z') {
				double num = nums[c-'A'];
				result.push(num);
			}
			// 연산자인 경우
			else {
				double num1 = result.pop();
				double num2 = result.pop();
				double rst = 0.0;
				switch(c) {
					case '+':{
						rst = num1 + num2;
						break;	
					}
					case '-':{
						rst = num2 - num1;
						break;	
					}
					case '*':{
						rst = num1 * num2;
						break;	
					}
					case '/':{
						rst = num2 / num1;
						break;	
					}
				}
				result.push(rst);
			}
		}
		System.out.printf("%.2f",result.pop());
	}
}
