import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class hjy11279 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++){
            int x = Integer.parseInt(br.readLine());

            if (x == 0){
                if (queue.isEmpty())
                    sb.append("0\n");
                else 
                	sb.append(queue.poll() + "\n");
            }
            else {
            	queue.offer(x);
            }
        }
        System.out.println(sb);

	}

}
