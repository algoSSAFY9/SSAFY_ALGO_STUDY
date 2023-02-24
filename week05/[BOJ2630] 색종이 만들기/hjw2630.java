import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hjw2630 {
	static int[][] arr;
	static int[] res;
	static int blue;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		res = new int[2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cal(0, 0, N);
		System.out.println(res[0]);
		System.out.println(res[1]);
		
	}
  
	static void cal(int row, int col, int sz) { 
		int who = arr[row][col];
		boolean chk = false;
		a : for(int i=row; i<row + sz; i++) {
			for(int j=col; j<col + sz; j++) {
				if(arr[i][j] != who) {
					chk = true;
					break a;
				}
			}
		}
		
		
		if(chk) {
			int size = sz / 2;
			cal(row, col, size);
			cal(row, col + size, size);
			cal(row + size, col, size);
			cal(row + size, col + size, size);
		}
		else {
			res[who]++;
		}
	}
}
