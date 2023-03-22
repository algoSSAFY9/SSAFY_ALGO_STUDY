import java.io.*;
import java.util.PriorityQueue;

public class kh1927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) sb.append((pq.isEmpty() ? 0 : pq.poll())).append("\n");
            else pq.offer(x);
        }
        System.out.println(sb);
    }
}
