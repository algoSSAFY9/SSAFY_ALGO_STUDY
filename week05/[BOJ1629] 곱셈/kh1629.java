import java.io.*;
import java.util.StringTokenizer;

public class kh1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        A %= C;

        bw.write(String.valueOf(solution(A, B, C)));
        bw.flush();
    }

    static int solution(int A, int B, int C) {
        if (B == 1) return A;

        long num = solution(A, B / 2, C);
        num = (num * num) % C;
        if (B % 2 == 1) num = (num * A) % C;

        return (int) num;
    }
}
