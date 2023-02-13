import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class kbs17413 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Character> stack = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

		char[] strArr = br.readLine().toCharArray();

		boolean isStack = true;
		for (char c : strArr) {
			if (c == '<') {
				while (!stack.isEmpty()) {
					sb.append(stack.poll());
				}
				sb.append(c);
				isStack = false;
				continue;
			}
			if (!isStack) { // < > 안의 값
				if (c == '>')
					isStack = true;
				sb.append(c);
			} else {

				if (c == ' ') {
					while (!stack.isEmpty()) {
						sb.append(stack.poll());
					}
					sb.append(" ");

				} else
					stack.addFirst(c);

			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.poll());
		}
		System.out.println(sb);
	}
}
