import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class hjw15787 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] str = new int[n+1][21];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken());
			int seat = Integer.parseInt(st.nextToken());
			if (num == 1) {
				int ng = Integer.parseInt(st.nextToken());
				str[seat][ng] = 1;
			} else if (num == 2) {
				int ng = Integer.parseInt(st.nextToken());
				str[seat][ng] = 0;
			} else if (num == 3) {
				for(int j=20; j>1; j--) {
					str[seat][j] = str[seat][j-1];
				}
				str[seat][1] = 0;
			} else if (num == 4) {
				for(int j=1; j<20; j++) {
					str[seat][j] = str[seat][j+1];
				}
				str[seat][20] = 0;
			}
		}
		
		HashSet<String> res = new HashSet<>();
		
		for(int i=1; i<n+1; i++) {
			res.add(Arrays.toString(str[i]));
		}

		System.out.println(res.size());
	}

}
