package algorithm_study.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BS9_14888 {

	static int[] arr, cal;
	static int N, min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		cal = new int[4]; // + - x /
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i]=Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) cal[i]=Integer.parseInt(st.nextToken());
		
		
		dfs(0, arr[0]);
		
		System.out.println(max);
		System.out.println(min);
	}

	static void dfs(int cnt, int result) {
		if(cnt==N-1){
			if(max<result) max=result;
			if(min>result) min=result;
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(cal[i]>0) {
				cal[i]--;
				dfs(cnt+1, calc(i, result, arr[cnt+1]));
				cal[i]++;
			}
		}
	}
	static int calc(int cal, int result, int b) {
		
		if(cal==0) {
			return result+b;
		}
		else if(cal==1) {
			return result-b;
		}
		else if(cal==2) {
			return result*b;
		}
		return result/b;
	}
}
