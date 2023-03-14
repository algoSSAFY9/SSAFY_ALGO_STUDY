import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class kh1003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[][] count = new int[2][41];
		count[0][0] = count[1][1] = 1;
		for (int i = 2; i <= 40; i++) {
			count[0][i] = count[0][i - 2] + count[0][i - 1];
			count[1][i] = count[1][i - 2] + count[1][i - 1];
		}

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
            sb.append(count[0][N]).append(" ").append(count[1][N]).append("\n");
		}
        System.out.println(sb);
	}
}
