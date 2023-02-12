package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hjy20436 {
	
	static char[][] key_list= {{'q','w','e','r','t','y','u','i','o','p'}
								,{'a','s','d','f','g','h','j','k','l'}
								,{'z','x','c','v','b','n','m'}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		
		String[] start = br.readLine().split(" ");  
		char start_l = start[0].charAt(0); 	// 왼손 초기 위치 문자
		char start_r = start[1].charAt(0); 	// 오른손 초기 위치 문자
		
		int sec = 0; // 총 걸리는 시간
		
		String str = br.readLine(); 	// 입력받은 문자열
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			// 문자가 모음인 경우 : 오른손
			if(ch=='y'||ch=='u'||ch=='i'||ch=='o'||ch=='p'||ch=='h'||ch=='j'||ch=='k'||ch=='l' ||ch=='b'||ch=='n'||ch=='m'){
			
				// 오른손 초기 위치 idx
				int[] r_idx = find_idx(start_r);
				// 목표 알파벳 위치 idx
				int[] move = find_idx(ch); 
				
				sec += distacnce(r_idx[0],r_idx[1],move[0],move[1]);
				
				start_r = ch; // 오른손 위치 갱신
			}
		
			// 문자가 자음인 경우 : 왼손
			else {
				int[] l_idx = find_idx(start_l);
				int[] move = find_idx(ch);
				
				sec += distacnce(l_idx[0],l_idx[1],move[0],move[1]);
				
				start_l=ch; // 왼손 위치 갱신
			}
		
			sec += 1; // 자판을 누르는 1초 count
		}
		
		System.out.println(sec);
	}
		
	// 입력 받은 문자 c의 위치 반환
	public static int[] find_idx(char c) {
		int[] result = new int[2]; 
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < key_list[i].length; j++) {
				if(key_list[i][j] == c) {
					result[0] = i;
					result[1] = j;
				}	
			}
		}
		return result;
	}
	
	// 이동 시간 구하는 함수
	public static int distacnce(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}
}
