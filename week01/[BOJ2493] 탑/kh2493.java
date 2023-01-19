import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class kh2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(st.nextToken()));
        }

        int[] ans = new int[N];
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        while (!stack.isEmpty()) {
            int h = stack.pop();
            Integer key;
            while ((key = tm.lowerKey(h)) != null) {
                ans[tm.get(key)] = N;
                tm.remove(key);
            }

            tm.put(h, --N);
        }
        for (int idx : tm.values()) {
            ans[idx] = 0;
        }

        for (int a : ans) {
            bw.write(a + " ");
        }

        bw.flush();
    }
}
