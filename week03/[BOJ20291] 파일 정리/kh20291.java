import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class kh20291 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> tm = new TreeMap<>();
        for (int n = 0; n < N; n++) {
            String 확장자 = br.readLine().split("\\.")[1];
            tm.put(확장자, tm.getOrDefault(확장자, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : tm.entrySet()) {
            bw.write(entry.getKey() + " " + entry.getValue() + "\n");
        }
        bw.flush();
    }
}
