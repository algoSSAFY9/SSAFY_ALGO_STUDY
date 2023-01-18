import java.io.*;
import java.util.Stack;

public class kh1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int order = 1;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            while (order <= num) {
                stack.push(order++);
                sb.append("+\n");
            }

            if (stack.pop() != num) {
                sb = new StringBuilder("NO");
                break;
            }

            sb.append("-\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}