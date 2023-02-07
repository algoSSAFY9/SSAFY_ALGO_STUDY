package algorithm_study.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BS9_1244 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int switch_cnt = Integer.parseInt(br.readLine()); // 스위치 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] switchs = new int[switch_cnt+1];
		
		for(int i=1; i<=switch_cnt; i++) switchs[i]=Integer.parseInt(st.nextToken());
		
		int students_cnt = Integer.parseInt(br.readLine());
		
		StringTokenizer str=null;
		for(int i=0; i<students_cnt; i++) {
			str = new StringTokenizer(br.readLine());
			int s_s = Integer.parseInt(str.nextToken());
			int s_num = Integer.parseInt(str.nextToken());
			
			if(s_s==1) { //남자
				int d=1;
				while(s_num*d<=switch_cnt) {
					switchs[s_num*d]=(switchs[s_num*d]+1)%2;
					d++;
				}
			}
			else { //여자
				switchs[s_num]=(switchs[s_num]+1)%2;
				
				int left=s_num;
				int right=s_num;
				while(left>1 && right<switch_cnt) {
					if(switchs[--left] == switchs[++right]) {
						switchs[left]=(switchs[left]+1)%2;
						switchs[right]=(switchs[right]+1)%2;
					}
					else break;
				}
			}
		}
		for(int i=1; i<=switch_cnt;i++) { // 출력값 생성
			sb.append(switchs[i]).append(" ");
			if(i%20==0)
				sb.append("\n");
			
		}
		System.out.println(sb);
	}
}
