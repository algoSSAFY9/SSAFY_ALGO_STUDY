import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

// 메모리 초과
public class hjy2346 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Deque<Integer> queue = new LinkedList<Integer>();	// 풍선 속 값
		Deque<Integer> queue_idx = new LinkedList<Integer>();	// 풍선 번호
			
		int N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		
		for(int i = 1; i < N+1; i++) {
			queue.offer(Integer.parseInt(str[i-1]));
			queue_idx.offer(i);
		}
		
		boolean flag = true;	// 이전 풍선의 값이 양수 : true, 음수 : false 
		while(queue.size() != 1) {
			// 이전 풍선 속 값이 양수일 경우
			if(flag) {
				// 앞의 풍선 속 값을 꺼냄
				int cur = queue.poll();
				int cur_idx = queue_idx.poll();
				// 현재 풍선 속 값이 양수일 경우
				if(cur > 0) {
					// 앞의 값들을 뒤로 보냄
					for(int j = 0; j < cur-1; j++) {
						queue.offerLast(queue.pollFirst());
						queue_idx.offerLast(queue_idx.pollFirst());
					}
				}
				// 현재 풍선 속 값이 음수일 경우
				else {
					// 뒤의 값들을 앞으로 가져옴
					for(int k = 0; k < cur*(-1)-1; k++) {
						queue.offerFirst(queue.pollLast());
						queue_idx.offerFirst(queue_idx.pollLast());
					}
					flag = false;
				}
				bw.write(cur_idx + " ");
			}
			// 이전 풍선 속 값이 음수일 경우
			else {
				// 맨뒤 풍선 속 값을 꺼냄
				int cur = queue.pollLast();
				int cur_idx = queue_idx.pollLast();
				if(cur > 0) {
					for(int j = 0; j < cur-1; j++) {
						queue.offerLast(queue.pollFirst());
						queue_idx.offerLast(queue_idx.pollFirst());
					}
				}
				else {
					for(int k = 0; k < cur*(-1)-1; k++) {
						queue.offerFirst(queue.pollLast());
						queue_idx.offerFirst(queue_idx.pollLast());
					}
					flag = false;
				}
				bw.write(cur_idx + " ");
			}
		}
		bw.write(queue_idx.poll().toString());
		
		bw.flush();
		bw.close();		
		br.close();
	}

}
