import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class hjw10866 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		Deque<Integer> dq = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String line = sc.next();
			switch (line) {
			case "push_front":
				dq.addFirst(sc.nextInt());
				break;
			case "push_back":
				dq.addLast(sc.nextInt());
				break;
			case "pop_front":
				if (dq.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(dq.removeFirst()).append("\n");
				break;
			case "pop_back":
				if (dq.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(dq.removeLast()).append("\n");
				break;
			case "size":
				sb.append(dq.size()).append("\n");
				break;
			case "empty":
				if (dq.isEmpty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
				break;
			case "front":
				if (dq.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(dq.getFirst()).append("\n");
				break;
			case "back":
				if (dq.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(dq.getLast()).append("\n");
				break;
			}
		}
		System.out.println(sb.toString());
	}

}
