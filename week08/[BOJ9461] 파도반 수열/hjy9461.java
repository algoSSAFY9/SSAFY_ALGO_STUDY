import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hjy9461 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int N;
		long num;
		
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			long[] arr = new long[100];
			arr[0] = 1;
			arr[1] = 1;
			arr[2] = 1;
			if(N <= 3) {
				sb.append(arr[N-1]).append("\n");
			}
			else {
				for (int i = 3; i < N; i++) {
					num = arr[i-2] + arr[i-3];
					arr[i] = num;
				}
				sb.append(arr[N-1]).append("\n");
			}
		}
		System.out.println(sb);
	}
}