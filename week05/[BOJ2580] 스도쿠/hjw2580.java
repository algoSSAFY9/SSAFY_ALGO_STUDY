import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class hjw2580 {
	static int[][] sudoku;
	static ArrayList<int[] > zero;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sudoku = new int[9][9];
		zero = new ArrayList<int[]>();
		
		for(int i=0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
				if(sudoku[i][j] == 0) 	zero.add(new int[] {i, j});
			}
		}
		cal(0);
	}
	
	static void cal(int idx) {
		if(idx == zero.size()) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(sudoku[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
			System.exit(0);
		}
		
		boolean[] chk = new boolean[10]; 
		int row = zero.get(idx)[0];
		int col = zero.get(idx)[1];
		
		// 행 
		for(int i=0; i<9; i++) {
			if(sudoku[i][col] != 0) chk[sudoku[i][col]] = true;
		}
		
		// 열
		for(int i=0; i<9; i++) {
			if(sudoku[row][i] != 0) chk[sudoku[row][i]] = true;
		}
		
		// 3*3
		int r = (row / 3) * 3, c = (col / 3) * 3;
		for(int i=r; i<r+3; i++) {
			for(int j=c; j<c+3; j++) {
				if(sudoku[i][j] != 0) chk[sudoku[i][j]] = true;
			}
		}
		
		for(int i=1; i<=9; i++) {
			if(!chk[i]) {
				sudoku[row][col] = i;
				cal(idx + 1);
				sudoku[row][col] = 0;
			}
		}
		
	}
}
