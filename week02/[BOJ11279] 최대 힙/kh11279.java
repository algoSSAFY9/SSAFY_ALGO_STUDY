import java.io.*;
import java.util.*;

public class kh11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x > 0) {
                pq.add(x);
            } else {
                bw.write(String.valueOf(pq.isEmpty() ? 0 : pq.remove()));
                bw.newLine();
            }
        }

        bw.flush();
    }
}
