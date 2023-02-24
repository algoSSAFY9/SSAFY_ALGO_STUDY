import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kbs2630 {
	
	static int[][] board;
	
	// main 
	public static void main(String[] args) throws Exception {
		// setting 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		func(0,N,0,N);
		System.out.println(white);
		System.out.println(blue);
		
	}
	static int white = 0;
	static int blue = 0;
	static void func(int startR, int endR,int startC, int endC ) {
		int whiteN = 0;
		int blueN = 0;
		boolean isAll =  false;
		
		if(startR==endR) {
			if(board[startR][startC] == 0) white ++;
			return;
		}
		
		for(int i=startR;i<endR;i++) {
			for(int j=startC;j<endC;j++) {
				if(board[i][j] == 1) blueN++;
				else whiteN++;
			}
		}
		
		if(whiteN==0) {
			blue++;
			isAll= true;
		}else if(blueN==0) {
			white++;
			isAll= true;
		}
		if(!isAll) {
			func(startR, (endR+startR)/2, startC, (endC+startC)/2);
			func(startR, (endR+startR)/2, (endC+startC)/2, endC);
			func((endR+startR)/2, endR, startC, (endC+startC)/2);
			func((endR+startR)/2, endR, (endC+startC)/2, endC);
		}
		
	}
	
}
