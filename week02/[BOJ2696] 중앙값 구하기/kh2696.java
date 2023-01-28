import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class kh2696 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int M = Integer.parseInt(br.readLine());
            bw.write((M / 2 + 1) + "\n");
            PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> pq2 = new PriorityQueue<>();
            pq1.offer(Integer.MIN_VALUE);
            pq2.offer(Integer.MAX_VALUE);
            for (int i = -1; i < (M - 1) / 10; i++) {
                if (i % 2 == 1) {
                    bw.newLine();
                }
                st = new StringTokenizer(br.readLine());
                int j = 1;
                while (st.hasMoreTokens()) {
                    int num = Integer.parseInt(st.nextToken());
                    if (j % 2 == 0) {
                        if (num < pq1.peek()) {
                            pq2.offer(pq1.poll());
                            pq1.offer(num);
                        } else {
                            pq2.offer(num);
                        }
                    } else {
                        if (pq2.peek() < num) {
                            pq1.offer(pq2.poll());
                            pq2.offer(num);
                        } else {
                            pq1.offer(num);
                        }
                        bw.write(pq1.peek() + " ");
                    }
                    j++;
                }
            }
            bw.newLine();
        }

        bw.flush();
    }
}
