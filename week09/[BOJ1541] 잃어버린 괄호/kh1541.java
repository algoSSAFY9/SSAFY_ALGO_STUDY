import java.io.*;
import java.util.Arrays;

public class kh1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String[] tmp = str.split("-", 2);
        int ans = Arrays.stream(tmp[0].split("\\+")).mapToInt(Integer::parseInt).sum();
        if (tmp.length == 2) ans -= Arrays.stream(tmp[1].split("[+-]")).mapToInt(Integer::parseInt).sum();
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
