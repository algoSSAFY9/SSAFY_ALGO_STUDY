package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hjy22858 {
	public static void main(String[] args) throws IOException {
     
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);		// 카드 수
        int mix = Integer.parseInt(str[1]);		// 섞은 횟수
        
        int[] S = new int[n + 1];	// mix만큼 섞은 결과물 : S배열
        int[] D = new int[n + 1];	// D 배열
        int[] P = new int[n + 1];	// P 배열
        int[] temp;

        str = br.readLine().split(" ");
        // S 배열
        for (int i = 1; i <= n; i++) {
            S[i] = Integer.parseInt(str[i-1]);
        }

        str = br.readLine().split(" ");
        // D 배열
        for (int i = 1; i <= n; i++) {
            D[i] = Integer.parseInt(str[i-1]);
        }

        P = S;
        // 섞은 횟수만큼 되돌리기
        for (int i = 0; i < mix; i++) {
            temp = new int[n+1];
            for (int j = 1; j <= n; j++) {
                temp[D[j]] = P[j];
            }
            P = temp;
        }

        
        for (int i = 1; i < n; i++) {
            sb.append(P[i]+ " ");
        }
        sb.append(P[n]);
        System.out.println(sb);

    }
}
