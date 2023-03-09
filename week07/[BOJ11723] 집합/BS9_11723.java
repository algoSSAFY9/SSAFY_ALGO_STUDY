package algorithm_study.week7;

import java.io.*;
import java.util.*;

public class BS9_11723 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		
		Set<Integer> set = new HashSet<>();
		
		int x=0;
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			case "add":{
				x = Integer.parseInt(st.nextToken());
				set.add(x);
				break;
			}
			case "remove":{
				x = Integer.parseInt(st.nextToken());
				set.remove(x);
				break;
			}
			case "check":{
				x = Integer.parseInt(st.nextToken());
				if(set.contains(x)) sb.append(1);
				else sb.append(0);
				sb.append("\n");
				break;
			}
			case "toggle":{
				x = Integer.parseInt(st.nextToken());
				if(set.contains(x)) set.remove(x);
				else set.add(x);
				break;
			}
			case "all":{
				set.clear();
				for(int j=1; j<=20; j++) {
					set.add(j);
				}
				break;
			}
			case "empty":{
				set.clear();
			}
			}
		}
		System.out.println(sb);
	}
}
