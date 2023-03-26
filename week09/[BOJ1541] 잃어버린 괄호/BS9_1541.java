package algorithm_study.week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BS9_1541 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String string = br.readLine();
		
		String[] str = string.split("[-+]");
		
		int cnt=0, minus=str.length;;
		for(int i=0; i<string.length(); i++) {
			if(string.charAt(i)=='+') cnt++;
			else if(string.charAt(i)=='-') {
				minus=cnt+1;
				break;
			}
		}
		int ans=0;
		for(int i=0; i<minus; i++) {
			ans+=Integer.parseInt(str[i]);
		}
		for(int i=minus; i<str.length; i++) {
			ans-=Integer.parseInt(str[i]);
		}
		System.out.println(ans);
	}
}
