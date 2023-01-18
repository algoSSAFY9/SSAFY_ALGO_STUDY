import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class kh10828 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<String> stack = new Stack<>();

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String command = sc.next();
            switch (command) {
                case "push":
                    stack.push(sc.next());
                    break;
                case "pop":
                    bw.write(stack.isEmpty() ? "-1" : stack.pop());
                    bw.newLine();
                    break;
                case "size":
                    bw.write(String.valueOf(stack.size()));
                    bw.newLine();
                    break;
                case "empty":
                    bw.write(stack.isEmpty() ? "1" : "0");
                    bw.newLine();
                    break;
                case "top":
                    bw.write(stack.isEmpty() ? "-1" : stack.peek());
                    bw.newLine();
                    break;
            }
        }

        bw.flush();
    }
}