package algoStudy.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 별 찍기 - 19
public class BS9_10994 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int length = 4*N-3;
		
		char[][] stars = new char[length/2+1][length];
		
		for(int i=0; i<length/2+1; i++) {
			for(int j=0; j<length; j++) {
				stars[i][j]=' ';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int up=i*2; up<length-2*i; up++) {
				stars[2*i][up]='*';
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=i*2; j<=length/2; j++) {
				stars[j][2*i]='*';
				stars[j][length-1-2*i]='*';
			}
		}
		
		for(int i=0; i<length/2+1; i++) {
			sb.append(stars[i]);
			sb.append("\n");
		}
		for(int i=length/2-1; i>=0; i--) {
			sb.append(stars[i]);
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

