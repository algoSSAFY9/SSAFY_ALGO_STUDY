import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class hjy2667 {
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static int[] homes = new int[25*25];	// 단지에 속한 집의 수
    static int n;	// 지도의 크기
    static int dangee = 0; // 단지 번호
    static boolean[][] isVisited = new boolean[25][25]; // 방문여부
    static int[][] map = new int[25][25]; // input

    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());	

        String str;
        // 지도 싱태 저장
        for(int i = 0; i < n; i++){
            str = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 1 && !isVisited[i][j]){
                    dangee++;
                    dfs(i,j);
                }
            }
        }

        Arrays.sort(homes);		//  단지내 집의 수 오름차순 정렬
        sb.append(dangee).append("\n");

        for(int i = 0; i < homes.length; i++){
            if(homes[i] != 0){
            	sb.append(homes[i]).append("\n");
            }
        }
        
        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        isVisited[x][y] = true;
        homes[dangee]++;	// 단지에 속한 집의 수 증가

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && ny >=0 && nx < n && ny < n){
                if(map[nx][ny] == 1 && !isVisited[nx][ny]){
                    dfs(nx,ny);
                }
            }
        }
    }
}
