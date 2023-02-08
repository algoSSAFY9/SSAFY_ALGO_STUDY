package algorithm_study.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 *  ZOAC 3
 *  
 *  양 손의 검지로만 타자를 침
 *  왼손 -> 자음
 *  오른손 -> 모음
 *  (x1,y1) -> (x2, y2) = |x1-x2|+|y1-y2|
 *  키를 누르는데 1의 시간 걸림
 *  두 손 동시 사용 불가
 *  
 *  [입력]
 *  SL, SR = 왼손 검지, 오른손 검지 시작 위치
 *  
 */
public class BS9_20436 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<Character, int[]> map = new HashMap<>();
		char[] keys = "qwertasdfgzxcvyuiophjklbnm".toCharArray();
		int[][] xy = {{0,0}, {0,1}, {0,2},{0,3},{0,4},
				{1,0}, {1, 1}, {1,2}, {1,3}, {1,4},
				{2,0}, {2,1}, {2,2}, {2,3},
				{-1, -2}, {-1, -3}, {-1, -4}, {-1, -5}, {-1, -6},
				{-2, -2}, {-2, -3}, {-2, -4}, {-2, -5},
				{-3, -1}, {-3, -2}, {-3, -3}
		};
		for(int i=0; i<26; i++) {
			map.put(keys[i], xy[i]);
		}
		
		String str = br.readLine();
		int[] pre_left = map.get(str.charAt(0));
		int[] pre_right = map.get(str.charAt(2));
		int time=0;
		
		String src = br.readLine();
		for(int i=0; i<src.length(); i++) {
			int[] cur = map.get(src.charAt(i));
			if(cur[0]<0) { // 오른손인 경우
				time+=Math.abs(pre_right[0]-cur[0])+Math.abs(pre_right[1]-cur[1])+1;
				pre_right=cur;
			}
			else {	// 왼손인 경우
				time+=Math.abs(pre_left[0]-cur[0])+Math.abs(pre_left[1]-cur[1])+1;
				pre_left=cur;
			}
		}
		System.out.println(time);
	}
}

