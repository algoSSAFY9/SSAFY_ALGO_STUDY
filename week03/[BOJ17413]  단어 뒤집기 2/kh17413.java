import java.io.*;

public class kh17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '<') {
                while (S.charAt(i) != '>') {
                    bw.write(S.charAt(i));
                    i++;
                }
                bw.write('>');
            } else if (S.charAt(i) == ' ') {
                bw.write(" ");
            } else {
                int left = i;
                while (i + 1 < S.length() && (S.charAt(i + 1) != ' ' && S.charAt(i + 1) != '<')) {
                    i++;
                }
                int right = i;
                while (left <= right) {
                    bw.write(S.charAt(right));
                    right--;
                }
            }
        }
        bw.flush();
    }
}
