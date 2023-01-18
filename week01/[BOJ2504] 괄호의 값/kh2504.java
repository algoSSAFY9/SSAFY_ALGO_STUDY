import java.io.*;
import java.util.Stack;

public class kh2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack1 = new Stack<>();

        String PS = br.readLine();
        boolean isVPS = true;
        for (int i = 0; i < PS.length(); i++) {
            if (PS.charAt(i) == '(' || PS.charAt(i) == '[') {
                stack1.push(PS.charAt(i));
            } else {
                if (stack1.isEmpty()) {
                    isVPS = false;
                    break;
                }

                char c = stack1.pop();
                if ((PS.charAt(i) == ')' && c == '[') || (PS.charAt(i) == ']' && c == '(')) {
                    isVPS = false;
                    break;
                }
            }
        }

        if (isVPS && stack1.isEmpty()) {
            PS = PS.replace("()", "2");
            PS = PS.replace("[]", "3");

            Stack<Integer> stack2 = new Stack<>();
            stack2.push(0);
            for (int i = 0; i < PS.length(); i++) {
                char c = PS.charAt(i);
                if (c == '(' || c == '[') {
                    stack2.push(0);
                } else if (c == ')' || c == ']') {
                    int num = stack2.pop() * (c == ')' ? 2 : 3);
                    stack2.push(stack2.pop() + num);
                } else {
                    stack2.push(stack2.pop() + c - '0');
                }
            }

            bw.write(String.valueOf(stack2.pop()));
        } else {
            bw.write("0");
        }

        bw.flush();
    }
}