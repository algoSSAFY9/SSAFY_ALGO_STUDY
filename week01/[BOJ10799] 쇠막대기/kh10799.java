import java.io.*;

public class kh10799 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String vps = br.readLine();
        vps = vps.replace("()", "L");
        int stack = 0;
        int ans = 0;
        for (int i = 0; i < vps.length(); i++) {
            switch (vps.charAt(i)) {
                case '(':
                    stack++;
                    break;
                case ')':
                    ans++;
                    stack--;
                    break;
                default:
                    ans += stack;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}