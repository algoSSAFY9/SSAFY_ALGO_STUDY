import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class hjy2075 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < N; i++){
        	// 한 줄 읽어옴
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	// 하나씩 큐에 offer
        	for(int j = 0; j < N; j++) {
        		queue.offer(Integer.parseInt(st.nextToken()));
        	}
        }
        // 찾으려는 N번째 앞 값들 poll
        for(int k = 0; k < N-1; k++) {
        	queue.poll();
        }
        // 찾으려는 N번째 값 poll
        System.out.println(queue.poll());
	}

}
