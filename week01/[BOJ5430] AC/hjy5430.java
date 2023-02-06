import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class hjy5430 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String op; // 함수 목록
		StringTokenizer nums;
		StringBuilder st;
		int T = Integer.parseInt(br.readLine()); // 테케의 수

		int n; // 배열의 크기
		String arr[]; // 입력받은 배열
		boolean error; // 에러의 유무
		boolean reverse; // 반전의 유무

		Deque<Integer> dq;

		for (int i = 0; i < T; i++) {
			dq = new LinkedList<>();
			st = new StringBuilder();
			op = br.readLine();
			n = Integer.parseInt(br.readLine());
			nums = new StringTokenizer(br.readLine(), "[],");
			reverse = false;
			error = false;

			for (int j = 0; j < n; j++) {
				dq.offerLast(Integer.parseInt(nums.nextToken()));
			}

			for (int k = 0; k < op.length(); k++) {
				if (op.charAt(k) == 'R') {
					reverse = !reverse;
				} else {
					if (dq.isEmpty()) {
						error = true;
						break;
					} else if (reverse) {
						dq.pollLast();
					} else
						dq.pollFirst();
				}
			}
			// 출력
			if (error)
				bw.write("error\n");
			else if (dq.size() == 0) {
				st.append("[]");
				bw.write(st + "\n");
			} else {
				if (reverse) {
					st.append('[');
					st.append(dq.pollLast());
					while (dq.size() > 0) {
						st.append("," + dq.pollLast());
					}
					st.append("]");
					bw.write(st + "\n");
				} else {
					st.append('[');
					st.append(dq.pollFirst());
					while (dq.size() > 0) {
						st.append("," + dq.pollFirst());
					}
					st.append("]");
					bw.write(st + "\n");
				}
			}

		}
		bw.flush();
	}

}
