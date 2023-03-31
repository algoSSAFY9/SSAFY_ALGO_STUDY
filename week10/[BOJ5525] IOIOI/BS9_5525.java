package study;

import java.io.*;

public class BS9_5525 {

	static int N, M, ans;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine())*2+1;
        M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        
        int cnt=0;
        for(int i=0; i<M; i++) {
        	if(S.charAt(i)=='I') {
        		cnt++;
        		if(cnt%2==0) {
        			check(cnt-1);
        			cnt=1;
        		}
        	}
        	else {
        		if(cnt!=0) {
        			cnt++;
        			if(cnt%2==1) {
        				check(cnt-1);
        				cnt=0;
        			}
        		}
        	}
        }
        if(cnt!=1 || cnt!=0) check(cnt);
        
        System.out.println(ans);
	}
	static void check(int cnt) {
		if(cnt>=N) {
    		ans++;
    		ans+=(cnt-N)/2;
    	}
	}
}
