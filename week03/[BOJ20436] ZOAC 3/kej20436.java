package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class kej20436 {
	static Character[][] key = { { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' },
								{ 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l' },
								{ 'z', 'x', 'c', 'v', 'b', 'n', 'm' } };
	static int x = 0;
	static int y = 0;
	static int now_Lx,now_Ly,now_Rx,now_Ry;
	static int now_y;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char L = s.charAt(0);
		char R = s.charAt(2);
		
		findIdx(L);		// 왼손 처음 좌표
		now_Lx = x;
		now_Ly = y;
		findIdx(R);		// 오른손 처음 좌표
		now_Rx = x;
		now_Ry = y;
		s = br.readLine();
		int time = 0;
		for (int t = 0; t < s.length(); t++) {
			switch (s.charAt(t)) {		
			// 왼쪽 키보드
			case 'q':case 'w':case 'e':case 'r':case 't':
			case 'a':case 's':case 'd':case 'f':case 'g':
			case 'z':case 'x':case 'c':case 'v':
				findIdx(s.charAt(t));
				time += Math.abs(now_Lx-x)+Math.abs(now_Ly-y)+1;
				now_Lx = x;
				now_Ly = y;
				break;
			// 오른쪽 키보드
			case 'y':case 'u':case 'i':case 'o':case 'p':
			case 'h':case 'j':case 'k':case 'l':
			case 'b':case 'n':case 'm':
				findIdx(s.charAt(t));
				time += Math.abs(now_Rx-x)+Math.abs(now_Ry-y)+1;
				now_Rx = x;
				now_Ry = y;
				break;
			}
		}
		
		System.out.println(time);

	}
	
	static void findIdx(char a) {
		for(int i = 0; i<3;i++) {
			for(int j = 0;j<key[i].length;j++) {
				if(key[i][j]==a) {
					x = i;
					y = j;
					return;
				}
			}
		}
	}

}
