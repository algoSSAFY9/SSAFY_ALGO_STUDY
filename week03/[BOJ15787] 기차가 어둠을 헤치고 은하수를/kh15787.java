import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class kh15787 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] trains = new int[N];
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int x;
            switch (command) {
                case 1:
                    x = Integer.parseInt(st.nextToken()) - 1;
                    trains[i] |= 1 << x;
                    break;
                case 2:
                    x = Integer.parseInt(st.nextToken()) - 1;
                    trains[i] &= ~(1 << x);
                    break;
                case 3:
                    trains[i] <<= 1;
                    trains[i] %= (1 << 20);
                    break;
                case 4:
                    trains[i] >>= 1;
                    trains[i] %= (1 << 20);
                    break;
            }
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int train : trains) hs.add(train);
        bw.write(String.valueOf(hs.size()));
        bw.flush();
    }
}
