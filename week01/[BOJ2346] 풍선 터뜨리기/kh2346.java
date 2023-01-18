import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class kh2346 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> balloons = new ArrayList<>();
        int[] papers = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            balloons.add(i);
            papers[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0, balloon;
        while (balloons.size() > 1) {
            balloon = balloons.get(idx);
            bw.write(balloon + " ");
            balloons.remove(idx);
            idx = (idx + (papers[balloon] % balloons.size()) + (papers[balloon] > 0 ? -1 : 0) + balloons.size()) % balloons.size();
        }
        bw.write(String.valueOf(balloons.get(idx)));

        bw.flush();
    }
}