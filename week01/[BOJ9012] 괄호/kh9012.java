import java.io.*;
import java.util.Stack;

public class kh9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            Stack<Character> stack = new Stack<>();

            String PS = br.readLine();
            boolean isVPS = true;
            for (int i = 0; i < PS.length(); i++) {
                if (PS.charAt(i) == '(') {
                    stack.push(PS.charAt(i));
                } else {
                    if (stack.isEmpty()) {
                        isVPS = false;
                        break;
                    }

                    stack.pop();
                }
            }

            bw.write(isVPS && stack.isEmpty() ? "YES" : "NO");
            bw.newLine();
        }

        bw.flush();
    }
}