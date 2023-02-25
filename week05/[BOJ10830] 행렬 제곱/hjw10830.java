import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hjw10830 {
	static int[][] arr;
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken()); 
		
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}
		
		arr = cal(arr, b);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int[][] cal(int[][] arr, long tmp) {
		if(tmp == 1) {
			return arr;
		}
		
		int[][] temp = cal(arr, tmp / 2);
		
		temp = proc(temp, temp);
		
		if(tmp % 2 == 1) {
			temp = proc(temp, arr);
		}

		return temp;
	}
	
	static int[][] proc(int[][] arr, int[][] arr2) {
		int[][] res = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					res[i][j] += (arr[i][k] * arr2[k][j]);
					res[i][j] %= 1000;
				}
			}
		}
		
		return res;
	}
}
