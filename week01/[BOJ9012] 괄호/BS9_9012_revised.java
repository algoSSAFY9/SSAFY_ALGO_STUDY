package algorithm_study;
//9012번

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BS9_9012_revised {

	static int T;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			String ps=br.readLine();
			int len = ps.length();
			int cnt=0;
			
			for(int j=0; j<len; j++) {
				if(ps.charAt(j)=='(') cnt++;
				else cnt--;
				
				if(cnt<0) break;
			}
			if(cnt==0) System.out.println("YES");
			else System.out.println("NO");
			
		}
	}
}
