import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hjy1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        int[][] map = new int[41][2];
        
        map[0][0] = 1;
        map[0][1] = 0;
        map[1][0] = 0;
        map[1][1] = 1;
        
        for (int i = 2; i <= 40; i++) {
			map[i][0] = map[i-1][1];
			map[i][1] = map[i-1][0] + map[i-1][1];
		} 
        
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            sb.append(map[N][0]).append(" ").append(map[N][1]).append("\n");
        }
        System.out.println(sb);
    }
}
