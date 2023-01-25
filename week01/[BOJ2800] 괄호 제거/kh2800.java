import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

public class kh2800 {

    static TreeSet<String> ts;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        ts = new TreeSet<>();
        run(0, str, new StringBuilder(), new Stack<>());
        ts.pollFirst();
        for (String t : ts) {
            System.out.println(t);
        }
    }

    public static void run(int i, String str, StringBuilder sb, Stack<Boolean> stack) {
        if (i == str.length()) {
            ts.add(sb.toString());
            return;
        }

        char c = str.charAt(i);
        if (c == '(') {
            sb.append(c);
            stack.push(true);
            run(i + 1, str, sb, stack);
            sb.deleteCharAt(sb.length() - 1);
            stack.pop();

            stack.push(false);
            run(i + 1, str, sb, stack);
            stack.pop();
        } else if (c == ')') {
            if (stack.pop()) {
                sb.append(c);
                run(i + 1, str, sb, stack);
                sb.deleteCharAt(sb.length() - 1);
                stack.push(true);
            } else {
                run(i + 1, str, sb, stack);
                stack.push(false);
            }
        } else {
            sb.append(c);
            run(i + 1, str, sb, stack);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
