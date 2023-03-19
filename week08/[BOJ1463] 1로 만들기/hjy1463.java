import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hjy1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        int[] rst = new int[x + 1];

        rst[0] = 0;
        rst[1] = 0;
        		

        for (int i = 2; i <= x; i++) {
        	// 먼저 1 뺴야되는 경우 : 이전 결과 + 1 
        	int temp = rst[i-1] + 1;
        	if(i%6 == 0) {
        		int temp2 = rst[i/2] + 1;
        		int temp3 = rst[i/3] + 1;
        		rst[i] = Math.min(temp, Math.min(temp2, temp3));
        	}
        	else if(i%2 == 0) {
        		int temp2 = rst[i/2] + 1;
        		rst[i] = Math.min(temp, temp2);
        	}
        	else if(i%3 == 0) {
        		int temp2 = rst[i/3] + 1;
        		rst[i] = Math.min(temp, temp2);
        	}
        	else {
        		rst[i] = temp;
        	}
        }
        System.out.println(rst[x]);
    }
}
