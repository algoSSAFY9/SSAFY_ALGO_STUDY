import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hjy9095 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
        int T = Integer.parseInt(br.readLine());
        int rst[] = new int[11];
        
        rst[1] = 1;		// 1을 만드는 경우
        rst[2] = 2;		// 2를 만드는 경우
        rst[3] = 4;		// 3을 만드는 경우
        
        for(int i = 4; i < 11; i++) {
        	rst[i] = rst[i-1] + rst[i-2] + rst[i-3];
        }
        
        for(int i = 0; i < T; i++){
        	int n = Integer.parseInt(br.readLine());
        	sb.append(rst[n]).append("\n");
        }
        
        System.out.println(sb);
    }
}
