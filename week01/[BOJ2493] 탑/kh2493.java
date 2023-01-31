import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class kh2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> idx = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int h = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek() < h) {
                stack.pop();
                idx.pop();
            }
            bw.write((stack.isEmpty() ? 0 : idx.peek()) + " ");

            stack.push(h);
            idx.push(i);
        }
        bw.flush();
    }
}
