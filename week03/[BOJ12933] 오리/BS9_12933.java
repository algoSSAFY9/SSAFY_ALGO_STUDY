package algoStudy.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BS9_12933 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int[] cnt = new int[5];
		int count=0;
		int max = Integer.MIN_VALUE;
		
		HashMap<Character, Integer> quack = new HashMap<>();
		String str="quack";
		for(int i=0; i<5; i++) quack.put(str.charAt(i), i);
		
		str = br.readLine();
		if(str.length()%5!=0) {
			System.out.println(-1);
			return;
		}
		for(char c : str.toCharArray()) {
			int idx = quack.get(c);
			if(idx==0) {
				cnt[idx]++;
			}
			else {
				cnt[idx]++;
				if(cnt[idx-1]<cnt[idx]) {
					System.out.println(-1);
					return;
				}
				if(idx==4) {
					max = Math.max(max, cnt[0]-count);
					count++;
				}
			}
			
		}
		int a=cnt[0]&cnt[1]&cnt[2]&cnt[3]&cnt[4];
		if(a==0) System.out.println(-1);
		else System.out.println(max);
	}
}
