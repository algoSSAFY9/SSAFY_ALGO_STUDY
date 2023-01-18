import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class kh18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Deque<String> queue = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    queue.offer(st.nextToken());
                    break;
                case "pop":
                    bw.write(queue.isEmpty() ? "-1" : queue.poll());
                    bw.newLine();
                    break;
                case "size":
                    bw.write(String.valueOf(queue.size()));
                    bw.newLine();
                    break;
                case "empty":
                    bw.write(queue.isEmpty() ? "1" : "0");
                    bw.newLine();
                    break;
                case "front":
                    bw.write(queue.isEmpty() ? "-1" : queue.peekFirst());
                    bw.newLine();
                    break;
                case "back":
                    bw.write(queue.isEmpty() ? "-1" : queue.peekLast());
                    bw.newLine();
                    break;
            }
        }

        bw.flush();
    }
}