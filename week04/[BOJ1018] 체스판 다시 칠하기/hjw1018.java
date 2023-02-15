import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hjw1018 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[][] arr = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = line.charAt(j) == 'B' ? true : false;
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<n-7; i++) { // 시작점
			for(int j=0; j<m-7; j++) { // 시작점
				
				boolean start = arr[i][j];
				int cnt = 0;
				for(int x = i; x < i+8; x++) {
					for(int y = j; y < j+8; y++) {
						if(arr[x][y] == start) {
							cnt++;
						}
						start = !start;
					}
					start = !start;
				}
				
				int chk = Math.min(cnt, 64 - cnt);
				min = Math.min(min, chk);
			}
		}
		System.out.println(min);
	}

}
