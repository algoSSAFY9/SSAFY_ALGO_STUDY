import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class hjy1874 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int idx = 0;
		
		// 만들고자 하는 수열 저장
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		// 1부터 차례대로 스택에 push
		for(int j = 1; j < N+1; j++) {
			stack.push(j);
			sb.append("+\n");
			// 하나 push 할 때마다 만들고자 하는 수열과 비교
			while(!stack.isEmpty() && nums[idx] == stack.peek()) {
				// 수열 값과 일치할 경우 : pop
				if(nums[idx] == stack.peek()) {
					stack.pop();
					sb.append("-\n");
					idx++;
				}
			}
		}
		// stack에서 모든 값을 꺼내 경우 : 수열 완성!
		if (stack.empty()) {
			System.out.println(sb);	
			br.close();
		}
		// 수열 만들지 못함
		else {
			System.out.print("NO");
		}
	}
}
