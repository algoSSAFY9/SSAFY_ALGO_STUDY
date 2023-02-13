import java.io.*;
import java.util.StringTokenizer;

public class kh2615 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] map = new int[21][21];
        for (int i = 1; i <= 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] directions = {{-1, 1}, {0, 1}, {1, 1}, {1, 0}};
        int winner = 0;
        int r = -1, c = -1;
        for (int i = 1; i <= 19 && winner == 0; i++) {
            for (int j = 1; j <= 19 && winner == 0; j++) {
                if (map[i][j] != 0) {
                    for (int[] direction : directions) {
                        boolean five = true;
                        for (int d = 1; d < 5; d++) {
                            if (map[i + direction[0] * d][j + direction[1] * d] != map[i][j]) {
                                five = false;
                                break;
                            }
                        }

                        if (five && !(map[i - direction[0]][j - direction[1]] == map[i][j] || map[i + direction[0] * 5][j + direction[1] * 5] == map[i][j])) {
                            winner = map[i][j];
                            r = i;
                            c = j;
                        }
                    }
                }
            }
        }

        System.out.println(winner);
        if (winner != 0) {
            System.out.println(r + " " + c);
        }
    }
}
