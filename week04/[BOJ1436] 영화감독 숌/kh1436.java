import java.io.*;

public class kh1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int num = 666;
        while (N > 0) {
            if (String.valueOf(num).contains("666")) N--;

            num++;
        }
        bw.write(String.valueOf(num - 1));
        bw.flush();
    }
}
