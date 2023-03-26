import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class kh17626 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> 제곱수들 = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) 제곱수들.add(i * i);

        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[n + 1];
        q.offer(0);
        while (ans[n] == 0) {
            int num = q.poll();
            for (int 제곱수 : 제곱수들) {
                int next_num = num + 제곱수;

                if (next_num > n) break;

                if (ans[next_num] == 0) {
                    ans[next_num] = ans[num] + 1;
                    q.offer(next_num);
                }
            }
        }
        bw.write(String.valueOf(ans[n]));
        bw.flush();
    }
}
