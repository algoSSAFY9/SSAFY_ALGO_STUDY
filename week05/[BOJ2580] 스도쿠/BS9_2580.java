package algoStudy.백트래킹;

import java.io.*;
import java.util.*;

public class BS9_2580 {

	static int[][] row,col,block, map;
	static int COUNT=0;
	static List<int[]> blank;
	static int[] ans;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		row = new int[9][10];
		col = new int[9][10];
		block = new int[9][10];
		map = new int[9][9];
		blank = new ArrayList<>();
		
		for(int i=0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j]=n;
				if(n==0) {
					blank.add(new int[] {i, j});
				}
				else {
					row[i][n]=1;
					col[j][n]=1;
					block[(i/3)*3+j/3][n]=1;
				}
			}
		}
		COUNT = blank.size();
		ans=new int[COUNT];
		
		dfs(0);
	}
	
	static void dfs(int cnt) {
		if(cnt==COUNT) {
			int t=0;
			for(int[] a : blank) {
				map[a[0]][a[1]]=ans[t++];
			}
			
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
            System.out.println(sb);
			System.exit(0);
		}

		int[] a = blank.get(cnt);
        	int k = (a[0]/3)*3+a[1]/3;
		for(int j=1; j<=9; j++) {
			if(row[a[0]][j]+col[a[1]][j]+block[k][j]==0) {
				row[a[0]][j]=1;
				col[a[1]][j]=1;
				block[k][j]=1;
				ans[cnt]=j;
				dfs(cnt+1);
				row[a[0]][j]=0;
				col[a[1]][j]=0;
				block[k][j]=0;
			}
		}
		return;
	}
}
