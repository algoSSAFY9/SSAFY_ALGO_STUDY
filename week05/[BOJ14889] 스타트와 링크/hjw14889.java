import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hjw14889 {
	static int[][] arr;
	static boolean[] chk;
	static int n, min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		chk = new boolean[n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cal(0, 0);
		System.out.println(min);
	}
	
	static void cal(int depth, int idx) {
		if(min == 0) return;
		if(depth == n/2) {
			int start = 0, link = 0;
			for(int i=0; i<n; i++) {
				for(int j=i+1; j<n; j++) {
					if(chk[i] && chk[j]) start += arr[i][j] + arr[j][i];
					else if(!chk[i] && !chk[j]) link += arr[i][j] + arr[j][i];
				}
			}
			min = Math.min(min, Math.abs(start-link));
			return;
		}
		
		for(int i=idx; i<n; i++) {
			if(chk[i]) continue;
			chk[i] = true;
			cal(depth + 1, i+1);
			chk[i] = false;
		}
	}
}
