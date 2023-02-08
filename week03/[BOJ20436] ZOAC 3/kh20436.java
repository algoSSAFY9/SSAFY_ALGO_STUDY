import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class kh20436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        char[][] keyboard = {
                {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
                {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
                {'z', 'x', 'c', 'v', 'b', 'n', 'm'}
        };

        HashMap<Character, int[]> hm = new HashMap<>();
        for (int i = 0; i < keyboard.length; i++) {
            for (int j = 0; j < keyboard[i].length; j++) {
                hm.put(keyboard[i][j], new int[]{i, j});
            }
        }

        st = new StringTokenizer(br.readLine());
        char S_L = st.nextToken().charAt(0), S_R = st.nextToken().charAt(0);

        int[] L = hm.get(S_L), R = hm.get(S_R);
        String str = br.readLine();
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            int[] c = hm.get(str.charAt(i));
            if ((c[0] < 2 && c[1] < 5) || (c[0] == 2 && c[1] < 4)) {
                ans += Math.abs(L[0] - c[0]) + Math.abs(L[1] - c[1]) + 1;
                L = c;
            } else {
                ans += Math.abs(R[0] - c[0]) + Math.abs(R[1] - c[1]) + 1;
                R = c;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
