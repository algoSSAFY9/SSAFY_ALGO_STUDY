import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hjy1780 {
    static int[][] map;
    static int[] cnt;	// -1, 0, 1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        cnt = new int[3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
            	map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide1(0, 0, N);

        System.out.println(cnt[0]);
        System.out.println(cnt[1]);        
        System.out.println(cnt[2]);        
 
    }

    private static void divide1(int x, int y, int n) {
		boolean flag = true;	// 수 통일 여부
		
		// 수 통일 되어 있는지 탐색
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				// 다른 수 하나 있을 경우
				if(map[x][y] != map[x + i][y + j]) {
					flag = false;
					break;
				}
				if(!flag) break;
			}
		}
		
		// 탐색한 영역이 한가지 수로 통일된 경우
		if (flag) { // 같은 수로 되어 있을 때
			if(map[x][y] == -1) {			// -1
				cnt[0]++;
			}else if(map[x][y] == 0){		// 0
				cnt[1]++;			
			}
			else {							// 1
				cnt[2]++;
			}
		}else {
			divide1(x, y, n/3);				
			divide1(x, y + n/3, n/3);			
			divide1(x, y + n*2/3, n/3);				
			divide1(x + n/3, y, n/3);				
			divide1(x + n/3, y + n/3, n/3);			
			divide1(x + n/3, y + n*2/3, n/3);			
			divide1(x + n*2/3, y, n/3);				
			divide1(x + n*2/3, y + n/3, n/3);			
			divide1(x + n*2/3, y + n*2/3, n/3);		
		}
	}
    
//	  // 개선 방법     
//    private static void divide2(int x, int y, int n) {
//		boolean flag = true;	// 수 통일 여부
//        int tmp = map[x][y];
//        for (int i = x; i < x + n; i++) {
//            for (int j = y; j < y + n; j++) {
//                if (tmp != map[i][j]) {
//                	flag = false;
//                	break;
//                }
//                if(!flag) break;
//            }
//        }
//        
//        if (flag) { // 같은 수로 되어 있을 때
//			if(map[x][y] == -1) {		
//				cnt[0]++;
//			}else if(map[x][y] == 0){
//				cnt[1]++;			
//			}
//			else {
//				cnt[2]++;
//			}
//        } else {    // 같은 수로 되어있지 않을 때
//            int new_n = n / 3;
//            for (int i = 0; i < 3; i++) {
//                for (int j = 0; j < 3; j++) {
//                	divide2(x + new_n * i, y + new_n * j, new_n);
//                }
//            }
//        }
//    }

}
