import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class kh1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            int[] counts = new int[10];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int importance = Integer.parseInt(st.nextToken());
                queue.offer(importance);
                counts[importance]++;
            }

            int order = 1;
            loop:
            for (int importance = 9; importance > 0; importance--) {
                while (counts[importance] > 0) {
                    int doc = queue.poll();
                    if (doc != importance) {
                        queue.offer(doc);
                    } else {
                        if (M == 0) {
                            break loop;
                        }

                        counts[importance]--;
                        order++;
                    }

                    M = (M - 1 + queue.size()) % queue.size();
                }
            }

            bw.write(String.valueOf(order));
            bw.newLine();
        }

        bw.flush();
    }
}