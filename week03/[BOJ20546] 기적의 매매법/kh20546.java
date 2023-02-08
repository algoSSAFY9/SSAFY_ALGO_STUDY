import java.io.*;
import java.util.Arrays;

public class kh20546 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());
        int[] cash = {c, c};
        int[] stock = {0, 0};
        int[] prices = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < 14; i++) {
            stock[0] += cash[0] / prices[i];
            cash[0] %= prices[i];
        }

        int i = 3;
        while (i < 14) {
            if (prices[i - 3] > prices[i - 2] && prices[i - 2] > prices[i - 1] && prices[i - 1] > prices[i]) {
                stock[1] += cash[1] / prices[i];
                cash[1] %= prices[i];
                i += 3;
            } else if (prices[i - 3] < prices[i - 2] && prices[i - 2] < prices[i - 1] && prices[i - 1] < prices[i]) {
                cash[1] += stock[1] * prices[i];
                stock[1] += 0;
                i += 3;
            } else {
                i++;
            }
        }
        int compare = Integer.compare(cash[0] + stock[0] * prices[13], cash[1] + stock[1] * prices[13]);
        bw.write(compare == 0 ? "SAMESAME" : compare > 0 ? "BNP" : "TIMING");
        bw.flush();
    }
}
