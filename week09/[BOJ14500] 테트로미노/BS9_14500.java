package algorithm_study.week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BS9_14500 {

	static int N, M, max=Integer.MIN_VALUE;
	
	static int[][][] mino = new int[][][] {
		{{0,0},{1,0},{2,0},{3,0},{4},{0}}, {{0,0},{0,1},{0,2},{0,3},{0},{4}}, // 1, 2
		{{0,0},{0,1},{0,2},{1,0},{2},{3}}, {{0,0},{1,0},{2,0},{2,1},{3},{2}}, // 4, 5
		{{0,2},{1,0},{1,1},{1,2},{2},{3}}, {{0,0},{0,1},{1,1},{2,1},{3},{2}}, // 6, 7
		{{0,0},{1,0},{1,1},{2,1},{3},{2}}, {{0,1},{0,2},{1,0},{1,1},{2},{3}}, // 8, 9
		{{0,0},{0,1},{0,2},{1,1},{2},{3}}, {{0,1},{1,0},{1,1},{2,1},{3},{2}}, // 10, 11
		{{0,0},{1,0},{1,1},{2,0},{3},{2}}, {{0,1},{1,0},{1,1},{1,2},{2},{3}}, // 12, 13
		{{0,0},{0,1},{1,1},{1,2},{2},{3}}, {{0,1},{1,0},{1,1},{2,0},{3},{2}}, // 14, 15
		{{0,1},{1,1},{2,0},{2,1},{3},{2}}, {{0,0},{0,1},{0,2},{1,2},{2},{3}}, // 16, 17
		{{0,0},{0,1},{1,0},{2,0},{3},{2}}, {{0,0},{1,0},{1,1},{1,2},{2},{3}}, // 18, 19
		{{0,0},{0,1},{1,0},{1,1},{2},{2}} // 3
	};
	
	static int[][] matrix;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		matrix = new int[N][M];
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				matrix[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sum(i, j);
			}
		}
		System.out.println(max);
	}
	
	static void sum(int y, int x) {
		
		for(int t=0; t<mino.length; t++) {
			int[][] te = mino[t];
			if(y+te[4][0]>N || x+te[5][0]>M) continue;
			int sum = 0;
			for(int i=0; i<4; i++) {
				int ny = y + te[i][0];
				int nx = x + te[i][1];
				sum+=matrix[ny][nx];
			}
			max = Math.max(max, sum);
		}
	}
}
