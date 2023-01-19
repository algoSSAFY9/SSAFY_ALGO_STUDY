import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class kh22942 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] map = new int[2020001];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            map[x - r + 1010000] = i;
            map[x + r + 1010000] = -i;
        }

        Stack<Integer> stack = new Stack<>();
        boolean isValid = true;
        for (int i : map) {
            if (i == 0) continue;

            if (i > 0) {
                stack.push(i);
            } else {
                if (stack.isEmpty() || stack.pop() != -i) {
                    isValid = false;
                    break;
                }
            }
        }

        bw.write(isValid && stack.isEmpty() ? "YES" : "NO");

        bw.flush();
    }
}
