package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kej1018 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] arr = new char[N][M];
		int result = 1000000;
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		char check_B = 'B';
		char check_W = 'W';
		int cnt_B = 0;
		int cnt_W = 0;
		int flag = 0;
		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				cnt_B = 0;
				cnt_W = 0;
				for (int x = i; x < i + 8; x++) {
					for (int y = j; y < j + 8; y++) {
						if(arr[x][y]!=check_B) cnt_B++;
						if(arr[x][y]!=check_W) cnt_W++;
						
						if(check_B == 'B') check_B = 'W';
						else if(check_B == 'W') check_B = 'B';
						
						if(check_W == 'B') check_W = 'W';
						else if(check_W == 'W') check_W = 'B';
						
					}
					if(check_B == 'B') check_B = 'W';
					else if(check_B == 'W') check_B = 'B';
					
					if(check_W == 'B') check_W = 'W';
					else if(check_W == 'W') check_W = 'B';
				}
				if(Math.min(cnt_B, cnt_W) < result) result = Math.min(cnt_B, cnt_W);
				if(result == 0) {
					flag = 1;
					break;
				}
			}
			if(flag==1)break;
		}
		System.out.println(result);

	}

}
