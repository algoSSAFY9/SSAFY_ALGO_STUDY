import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class kh4358 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        TreeMap<String, Integer> tm = new TreeMap<>();
        int count = 0;
        String name;
        while ((name = br.readLine()) != null) {
            tm.put(name, tm.getOrDefault(name, 0) + 1);
            count++;
        }

        for (Entry<String, Integer> entry : tm.entrySet()) {
            bw.write(String.format("%s %.4f", entry.getKey(), (double) entry.getValue() / count * 100));
            bw.newLine();
        }

        bw.flush();
    }
}
