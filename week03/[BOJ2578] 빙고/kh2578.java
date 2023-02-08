import java.util.HashMap;
import java.util.Scanner;

public class kh2578 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                hm.put(sc.nextInt(), i * 5 + j);
            }
        }

        int[][] count = new int[4][];
        for (int i = 0; i < 2; i++) count[i] = new int[5];
        for (int i = 2; i < 4; i++) count[i] = new int[9];
        int line = 0;
        for (int i = 1; i <= 25; i++) {
            int rc = hm.get(sc.nextInt());
            int r = rc / 5, c = rc % 5;
            int[] idx = {r, c, r + c, c - r + 4};
            for (int j = 0; j < 4; j++) {
                if (++count[j][idx[j]] == 5) line++;
            }

            if (3 <= line) {
                System.out.println(i);
                break;
            }
        }
    }
}
