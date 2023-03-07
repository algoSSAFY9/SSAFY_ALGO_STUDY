import java.io.*;

public class kh1676 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(N / 5 + N / 25 + N / 125));
        bw.flush();
    }
}
