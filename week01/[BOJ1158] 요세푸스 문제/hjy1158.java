import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class hjy1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");		// 한줄씩 읽어옴
		
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		
		Queue<Integer> queue = new LinkedList<>();
		
		// 큐에 1~N까지 추가
		for(int i = 1; i <= N; i++){
			queue.offer(i);
		}
		
		bw.write("<");
		// 큐에 수 하나만 남을 때까지 반복
		for(int j = N; j > 1; j--) {
			// poll할 정수 앞 두 정수 poll해서 차례로 offer
			for(int k = 0; k < K-1; k++) {
				queue.offer(queue.poll());
			}
			// K번째 수 poll
			bw.write(queue.poll() + ", ");
		}
		// 마지막 수 poll
		bw.write(queue.poll() + ">");
		
		bw.flush();
		bw.close();		
		br.close();
	}
}
