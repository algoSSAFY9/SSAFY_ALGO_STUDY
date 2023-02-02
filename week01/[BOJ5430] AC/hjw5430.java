import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class hjw5430 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			String line = br.readLine();

			int n = Integer.parseInt(br.readLine());
			Deque<Integer> dq = new LinkedList<Integer>();

			String[] arr = br.readLine().split("\\[|,|\\]");
			for (int i = 1; i <= n; i++) {
				dq.add(Integer.parseInt(arr[i]));
			}

			int j = 0;
			boolean chk = false;
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == 'D') {
					if (dq.isEmpty()) {
						sb.append("error").append("\n");
						chk = true;
						break;
					}
					if (j % 2 != 0) dq.pollLast();
					else dq.pollFirst();
				} else j++;
			}

			int size = dq.size();
			if (!chk) {
				sb.append("[");
				for (int i = 0; i < size; i++) {
					if (j % 2 == 0) sb.append(dq.pollFirst());
					else sb.append(dq.pollLast());
					if (i < size - 1)
						sb.append(",");
				}
				sb.append("]").append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
