package algorithm_study.브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 덩치
 * (키, 몸무게) -> (x, y)
 * 키 & 몸무게 모두 커야 덩치가 크다고 할 수 있음.
 * 우위를 정할 수 없으면 공동 등수.
 */
public class BS9_7568 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] body = new int[N][2];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			body[i][0] = Integer.parseInt(st.nextToken());
			body[i][1] = Integer.parseInt(st.nextToken());
		}
		int cnt;
		for(int i=0; i<N; i++) {
			cnt=0;
			for(int j=0; j<N; j++) {
				if(body[i][0]<body[j][0] && body[i][1]<body[j][1]) cnt++;
			}
			sb.append(cnt+1).append(" ");
		}
		System.out.println(sb);
	}
}
