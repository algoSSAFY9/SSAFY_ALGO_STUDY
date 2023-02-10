import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hjw2578 {
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[5][5];
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				int x = Integer.parseInt(st.nextToken());
				cnt++;
				a : for(int k=0; k<5; k++) {
					for(int m=0; m<5; m++) {
						if(arr[k][m] == x) {
							arr[k][m] = 0;
							if(cnt > 4 && bingo(k, m) >= 3) {
								System.out.println(cnt);
								return;
							}
							break a;
						}
					}
				}
			}
		}
	}
	
	static int bingo(int x, int y) {
		int cnt = 0;
		boolean chk1 = true, chk2 = true, chk3 = true, chk4 = true;

		for(int i=0, k=4; i<5 && k>=0; i++, k--) {
			chk1 = true; chk2 = true;
			for(int j=0; j<5; j++) {
				if(arr[i][j] != 0) chk1 = false;
				if(arr[j][i] != 0) chk2 = false;
			}
			if(arr[i][i] != 0) chk3 = false;
			if(arr[i][k] != 0) chk4 = false;
			
			if(chk1) cnt++;
			if(chk2) cnt++;
		}
		if(chk3) cnt++;
		if(chk4) cnt++;
		return cnt;
	}
}
