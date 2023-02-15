package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class kej1436 {

	public static void main(String[] args) throws Exception {
		String num = "666";
		int cnt = 0;
		int result = 666;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		while (true) {
			if (Integer.toString(result).contains(num)) cnt++;
			if (cnt == n) break;
			result++;
		}
		System.out.println(result);
	}

}
