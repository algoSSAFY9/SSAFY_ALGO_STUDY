import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class hjy2164 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();

		// 큐에 1~N까지 추가
		for(int i = 1; i <= N; i++){
			queue.offer(i);
		}
		// 큐에 수 하나만 남을 때까지 반복
		for(int j = N; j > 1; j--) {
			queue.poll();			
			queue.offer(queue.poll());
		}
		// 마지막 수 poll
		bw.write(queue.poll().toString());
		
		bw.flush();
		bw.close();		
		br.close();
	}
}
