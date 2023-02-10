package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class kej12933 {

	public static void main(String[] args) throws Exception {
		char[] duck = { 'q', 'u', 'a', 'c', 'k' };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		ArrayList<Character> arr = new ArrayList<>();
		int idx = 0;
		int x_cnt = 0;
		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			arr.add(s.charAt(i));
		}

		while (true) {
			if (s.length() % 5 != 0 || arr.get(0) != 'q' || arr.size() % 5 != 0) { // 총 길이가 5의 배수가 아니면 바로 -1 출
				System.out.println(-1);
				break;
			}
			for (int i = 0; i < arr.size(); i++) {
				if (idx == 5)
					idx = 0;
				if (duck[idx] == arr.get(i)) {
					arr.remove(i);
					i--;
					x_cnt++;
					idx++;
				}
			}
			result++;
			if (x_cnt % 5 == 0 && x_cnt == s.length()) {
				System.out.println(result);
				break;
			} else if (arr.size()<5) {
				System.out.println(-1);
				break;
			}
		}
	}

}
