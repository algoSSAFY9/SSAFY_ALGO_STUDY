import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class kh10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Deque<String> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push_front":
                    deque.offerFirst(st.nextToken());
                    break;
                case "push_back":
                    deque.offerLast(st.nextToken());
                    break;
                case "pop_front":
                    bw.write(deque.isEmpty() ? "-1" : deque.pollFirst());
                    bw.newLine();
                    break;
                case "pop_back":
                    bw.write(deque.isEmpty() ? "-1" : deque.pollLast());
                    bw.newLine();
                    break;
                case "size":
                    bw.write(String.valueOf(deque.size()));
                    bw.newLine();
                    break;
                case "empty":
                    bw.write(deque.isEmpty() ? "1" : "0");
                    bw.newLine();
                    break;
                case "front":
                    bw.write(deque.isEmpty() ? "-1" : deque.peekFirst());
                    bw.newLine();
                    break;
                case "back":
                    bw.write(deque.isEmpty() ? "-1" : deque.peekLast());
                    bw.newLine();
                    break;
            }
        }

        bw.flush();
    }
}