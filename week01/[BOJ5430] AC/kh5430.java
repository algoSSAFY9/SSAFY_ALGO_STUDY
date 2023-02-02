import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class kh5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<String> deque = new ArrayDeque<>();
            String tmp = br.readLine();
            if (tmp.length() > 2) {
                deque.addAll(List.of(tmp.substring(1, tmp.length() - 1).split(",")));
            }

            boolean reverse = false;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'R') {
                    reverse = !reverse;
                } else {
                    if (n-- == 0) break;

                    if (!reverse) deque.removeFirst();
                    else deque.removeLast();
                }
            }

            if (n < 0) {
                bw.write("error\n");
            } else {
                bw.write("[");
                if (deque.size() > 0) {
                    if (!reverse) {
                        bw.write(deque.removeFirst());
                        while (!deque.isEmpty()) {
                            bw.write("," + deque.removeFirst());
                        }
                    } else {
                        bw.write(deque.removeLast());
                        while (!deque.isEmpty()) {
                            bw.write("," + deque.removeLast());
                        }
                    }
                }
                bw.write("]\n");
            }
        }
        bw.flush();
    }
}