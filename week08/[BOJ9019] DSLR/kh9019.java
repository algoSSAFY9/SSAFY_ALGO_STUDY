import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class kh9019 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());

            char[] c = {'D', 'S', 'L', 'R'};

            ArrayDeque<Integer> q = new ArrayDeque<>();
            boolean[] visited = new boolean[10000];
            int[] from = new int[10000];
            char[] cmd = new char[10000];
            q.offer(A);
            visited[A] = true;
            while (!visited[B]) {
                int num = q.poll();
                int[] next_nums = {(num * 2) % 10000, (num + 9999) % 10000, (num * 10 + num / 1000) % 10000, (num + num % 10 * 10000) / 10};
                for (int i = 0; i < 4; i++) {
                    if (!visited[next_nums[i]]) {
                        q.offer(next_nums[i]);
                        visited[next_nums[i]] = true;
                        from[next_nums[i]] = num;
                        cmd[next_nums[i]] = c[i];
                    }
                }
            }

            ArrayDeque<Character> stack = new ArrayDeque<>();
            for (int idx = B; idx != A; idx = from[idx]) stack.push(cmd[idx]);
            while (!stack.isEmpty()) bw.write(stack.pop());
            bw.newLine();
        }
        bw.flush();
    }
}
