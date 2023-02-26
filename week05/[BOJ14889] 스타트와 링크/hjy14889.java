import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hjy14889 {
	   static int n;
	   static int[][] map;
	   static int min = Integer.MAX_VALUE;
	   static boolean[] visit;

	   public static void main(String[] args) throws IOException {
	       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	       n = Integer.parseInt(br.readLine());

	       map = new int[n][n];

	       for (int i = 0; i < n; i++) {
	           StringTokenizer st = new StringTokenizer(br.readLine());
	           for (int j = 0; j < n; j++) {
	               map[i][j] = Integer.parseInt(st.nextToken());
	           }
	       }

	       visit = new boolean[n];
	       combination(0, 0);
	       System.out.println(min);


	   }

	   static void combination(int idx, int cnt) {
	       if (cnt == n/2) {
	    	   team();
	           return;
	       }

	       for (int i = idx; i < n; i++) { 
	           if (!visit[i]) {
	               visit[i] = true;
	               combination(i + 1, cnt + 1);
	               visit[i] = false;
	           }
	       }
	   }

	   static void team() {
	       int start = 0;
	       int link = 0;
	       for (int i = 0; i < n - 1; i++) {
	           for (int j = i; j < n; j++) {
	               if (visit[i] == true && visit[j] == true) {
	                   start += map[i][j];
	                   start += map[j][i];
	               } else if (visit[i] == false && visit[j] == false) {
	                   link += map[i][j];
	                   link += map[j][i];
	               }
	           }
	       }

	       int val = Math.abs(start - link);
	       min = Math.min(val, min);	// 기존 최솟값과 비교
	   }
}
