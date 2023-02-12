package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class hjy1244 {

	private static int N;		// 스위치의 개수
	private static int[] list;	// 스위치의 상태
	private static int s_n;		// 학생 수 
	private static int gender;	// 성별
	private static int num;		// 받은 수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N =	Integer.parseInt(br.readLine()); 
		list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		s_n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < s_n; i++) {
			String[] str = br.readLine().split(" ");
			gender = Integer.parseInt(str[0]);
			num = Integer.parseInt(str[1]);
			
			// 성별 :남자
			if(gender == 1) {
				for(int m = num-1; m < list.length; m += num) {
					if(list[m] == 1)
						list[m] = 0;
					else
						list[m] = 1;
				}
			}
			// 성별 여자
			else {
				for(int g = 1; g < num; g++) {
					if(num - 1 - g >= 0 && num - 1 + g < N) {
						if(list[num - 1 - g] == 1 && list[num - 1 + g] == 1) {
							list[num - 1 - g] = 0;
							list[num - 1 + g] = 0;
						}
						else if(list[num - 1 - g]== 0 && list[num - 1 + g]==0) {
							list[num - 1 - g] = 1;
							list[num - 1 + g] = 1;
						}
						else if(!(list[num - 1 - g]==list[num - 1 + g])){
							break;
						}
					}
					else
						break;
				}
				if(list[num-1] == 1)
					list[num-1] = 0;
				else
					list[num-1] = 1;
			}
		}

		for(int i=0; i< N; i++) {
			System.out.print(list[i] + " ");
			if((i+1) % 20 == 0)
				System.out.println();
		}
	}

}

