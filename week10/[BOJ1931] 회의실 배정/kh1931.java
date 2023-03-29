import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kh1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] data = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(data, (d1, d2) -> d1[1] == d2[1] ? d1[0] - d2[0] : d1[1] - d2[1]);

        int ans = 0;
        int time = 0;
        for (int[] d : data) {
            if (time <= d[0]) {
                ans++;
                time = d[1];
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
