import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class hjw1935 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		

		Stack<Double> stack = new Stack<>();
		String Line = br.readLine();
		
		double[] arr = new double[27];
		for(int i=0; i<n; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}
		
		double res = 0;
		for(int i=0; i<Line.length(); i++) {
			char ch = Line.charAt(i);

			switch(ch){
			case '*':
				res = (stack.pop() * stack.pop());
				stack.add(res);
				break;
			case '+':
				res = (stack.pop() + stack.pop());
				stack.add(res);
				break;
			case '/':
				double first = stack.pop();
				res = (double)(stack.pop() / first);
				stack.add(res);
				break;
			case '-':
				double fs = stack.pop();
				res = (stack.pop() - fs);
				stack.add(res);
				break;
			default:
				stack.add(arr[ch - 'A']);
			}
			
		}
		System.out.printf("%.2f", res);
		
		
	}

}