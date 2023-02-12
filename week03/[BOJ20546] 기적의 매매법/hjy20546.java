package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hjy20546 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int j_money = Integer.parseInt(br.readLine());	// 자산
		int s_money = j_money;
		int[] days = new int[14];	// 날짜별 주가
		String[] str = br.readLine().split(" ");
		int j_joo = 0;	//	준현 소유 주식
		int s_joo = 0;	// 성민 소유 주식
		
		int j_rst = 0;	// 준현 최종 자산
		int s_rst = 0;	// 성민 최종 자산
		
		for (int i = 0; i < 14; i++) {
			days[i] = Integer.parseInt(str[i]);
		}
		
		// 준현 자산 연산
		for (int j = 0; j < 14; j++) {
			if(j_money >= days[j]) {
				j_joo = j_money/days[j];
				j_money = j_money%days[j];
			}
			else if(j_money == 0){
				break;
			}
		}
		
		// 성민 자산 연산
		int up_cnt = 0;	// 주가 연속 상승 횟수
		int down_cnt = 0;	// 주가 연속 하락 횟수
		
		for (int k = 1; k < 14; k++) {
			// 연속 주가 상승
			if(days[k-1] > days[k]) {
				down_cnt++;
				up_cnt = 0;
			}
			// 연속 주가 하락
			else if(days[k-1] < days[k]) {
				up_cnt++;
				down_cnt = 0;
			}
			else
				continue;
			
			// 매수 경우
			if(down_cnt == 3) {
				if(s_money >= days[k]) {
					s_joo += s_money/days[k];
					s_money = s_money%days[k];
					down_cnt = 0;
				}
				else {
					down_cnt = 0;
				}
			}
			// 매도 경우
			else if(up_cnt == 3){
				s_money = s_joo * days[k] + s_money;
				s_joo = 0;
				up_cnt = 0;
			}
		}
				
				
		// 최종 자산 계산
		j_rst = j_joo*days[13] + j_money;
		s_rst = s_joo*days[13] + s_money;
		if(j_rst > s_rst) {
			System.out.print("BNP");
		}
		else if(j_rst == s_rst){
			System.out.print("SAMESAME");
		}
		else
			System.out.print("TIMING");
		
	}
}
