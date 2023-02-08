package 백준문제;

import java.util.Scanner;

public class kej10994 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int len = 1;
		for (int i = 0; i < n-1; i++)
			len += 4;
		int length = len;

		char[][] result = new char[len][len];

		// 먼저 공백으로 초기화

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				result[i][j] = ' ';
			}
		}

		for (int i = 0; i < len; i+=2) {
			for (int j = i; j < len; j++) {
				result[i][j] = '*';
				result[j][i] = '*';
				result[j][len-1] ='*';
				result[len-1][j]='*';
			}
			len-=2;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<length;i++) {
			sb.append(result[i]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
