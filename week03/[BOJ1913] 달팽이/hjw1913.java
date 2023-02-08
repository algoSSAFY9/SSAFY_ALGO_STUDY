import java.io.BufferedReader;
import java.io.InputStreamReader;

public class hjw1913 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int find = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][n];
		int idx = n*n;
		int start = 0, end = n-1;
		while(start <= end) {
			for(int i=start; i<=end; i++) {
				arr[i][start] = idx--;
			}
			for(int i=start+1; i<=end; i++) {
				arr[end][i] = idx--;
			}
			for(int i=end-1; i>=start; i--) {
				arr[i][end] = idx--;
			}
			for(int i=end-1; i>start; i--) {
				arr[start][i] = idx--;
			}
			start++; end--;
		}
		
		int row = 0, col = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] == find) {
					row = i+1; col = j+1;
				}
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		sb.append(row).append(" ").append(col);
		System.out.println(sb.toString());
	}

}
