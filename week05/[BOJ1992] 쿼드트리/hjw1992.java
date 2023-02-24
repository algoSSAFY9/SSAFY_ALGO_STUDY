import java.io.BufferedReader;
import java.io.InputStreamReader;

public class hjw1992 {
	
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}
		}
		
		cal(0, 0, N);
		System.out.println(sb.toString());
	}
	static StringBuilder sb = new StringBuilder();
	static void cal(int row, int col, int sz) {
		int now = arr[row][col];
		boolean chk = false;
		a : for(int i=row; i<row+sz; i++) {
			for(int j=col; j<col+sz; j++) {
				if(now != arr[i][j]) {
					chk = true;
					break a;
				}
			}
		}
		
		if(chk) {
			sz = sz / 2;
			sb.append("(");
			cal(row, col, sz);
			cal(row, col+sz, sz);
			cal(row+sz, col, sz);
			cal(row+sz, col+sz, sz);
			sb.append(")");
		}
		else {
			sb.append(now);
		}
	}
}
