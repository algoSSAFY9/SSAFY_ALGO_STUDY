import java.util.Scanner;
import java.util.Stack;

public class kh1918 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                System.out.print(c);
                if (!stack.isEmpty()) {
                    char tmp = stack.peek();
                    if (tmp == '*' || tmp == '/') {
                        System.out.print(stack.pop());
                    }
                }
            } else {
                if (c == ')') {
                    char tmp;
                    while ((tmp = stack.pop()) != '(') {
                        System.out.print(tmp);
                    }
                } else {
                    if (!stack.isEmpty()) {
                        char tmp;
                        switch (c) {
                            case '*':
                            case '/':
                                tmp = stack.peek();
                                if (tmp == '*' || tmp == '/') {
                                    System.out.print(stack.pop());
                                }
                                break;
                            case '+':
                            case '-':
                                tmp = stack.peek();
                                if (tmp == '+' || tmp == '-') {
                                    System.out.print(stack.pop());
                                }
                                break;
                        }
                    }

                    stack.push(c);
                }
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
