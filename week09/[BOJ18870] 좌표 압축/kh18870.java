import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class kh18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] X = new int[N];
        HashSet<Integer> hs = new HashSet<>();
        ArrayList<Integer> sorted_X = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(st.nextToken());
            if (!hs.contains(X[i])) sorted_X.add(X[i]);
            hs.add(X[i]);
        }

        Collections.sort(sorted_X);
        for (int x : X) sb.append(Collections.binarySearch(sorted_X, x)).append(" ");
        System.out.println(sb);
    }
}
