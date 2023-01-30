package algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BS9_10828 {
	
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int[] stack = new int[10000]; // 정수를 저장하는 스택
		int idx=0;
		
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			case "push":{
				stack[idx++]=Integer.parseInt(st.nextToken());
				break;
			}
			case "pop":{
				if(idx>0) {
					System.out.println(stack[idx-1]);
					stack[idx-1]=0;
					idx--;
				}
				else System.out.println(-1);
				break;
			}
			case "size":{
				System.out.println(idx);
				break;
			}
			case "empty":{
				if(idx==0) System.out.println(1);
				else System.out.println(0);
				break;
			}
			case "top":{
				if(idx>0) System.out.println(stack[idx-1]);
				else System.out.println(-1);
				break;
			}
			default: i--;
			}
		}
	}
}
