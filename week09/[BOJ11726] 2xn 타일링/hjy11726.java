import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hjy11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] rst = new int[1001]; 
        rst[1] = 1;
        rst[2] = 2;
        for (int i = 3; i <= n; i++) {
        	rst[i] = (rst[i - 1] + rst[i - 2]) % 10007;
        }
        System.out.println(rst[n]);
    }
}
