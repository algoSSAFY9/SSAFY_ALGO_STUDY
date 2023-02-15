package algorithm_study.브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 영화감독 숌
 * 666이 들어간 수 중에 N번째 수 출력
 */
public class BS9_1436 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int num=666;
		int cnt=0;
		while(true) {
			if(String.valueOf(num).contains("666")) {
				if(N==++cnt) {
					System.out.println(num);
					break;
				}
			}
			num++;
		}
	}
}
