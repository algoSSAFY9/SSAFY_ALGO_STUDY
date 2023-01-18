import java.io.*;
import java.util.Stack;

public class kh1935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String postfix = br.readLine();
        double[] num = new double[N];
        for (int i = 0; i < N; i++) {
            num[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (Character.isUpperCase(c)) {
                stack.push(num[c - 'A']);
            } else {
                double num2 = stack.pop();
                double num1 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(num1 + num2);
                        break;
                    case '-':
                        stack.push(num1 - num2);
                        break;
                    case '*':
                        stack.push(num1 * num2);
                        break;
                    case '/':
                        stack.push(num1 / num2);
                        break;
                }
            }
        }

        bw.write(String.format("%.2f", stack.peek()));

        bw.flush();
    }
}