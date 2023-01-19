import java.io.*;
import java.util.*;

public class kh11286 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> {
            int abs1 = Math.abs(i1), abs2 = Math.abs(i2);
            return (abs1 == abs2) ? i1 - i2 : abs1 - abs2;
        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                bw.write(String.valueOf(pq.isEmpty() ? 0 : pq.remove()));
                bw.newLine();
            } else {
                pq.add(x);
            }
        }

        bw.flush();
    }
}
