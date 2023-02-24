import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hjw1780 {
	static int[][] arr;
	static int[] res;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		res = new int[3];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cal(0, 0, N);
		System.out.println(res[0]);
		System.out.println(res[1]);
		System.out.println(res[2]);
	}
	
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
			sz = sz / 3;
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					cal(row+(sz*i), col+(sz*j), sz);
				}
			}
		}
		else {
			res[now+1]++;
		}
	}
}
