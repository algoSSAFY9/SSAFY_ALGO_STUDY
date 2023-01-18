import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class kh1158 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = sc.nextInt(), K = sc.nextInt() - 1;

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            arr.add(i);
        }

        bw.write("<");
        int idx = 0;
        while (arr.size() > 1) {
            idx = (idx + K) % arr.size();
            bw.write(arr.get(idx) + ", ");
            arr.remove(idx);
        }
        bw.write(arr.get(0) + ">");

        bw.flush();
    }
}