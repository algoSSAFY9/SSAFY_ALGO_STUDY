import java.io.*;
import java.util.HashSet;

public class kh4396 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 2][n + 2];
        HashSet<Integer> mines = new HashSet<>();
        int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        for (int i = 1; i <= n; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 1; j <= n; j++) {
                if (c[j - 1] == '*') {
                    map[i][j] = Integer.MIN_VALUE;
                    mines.add(i * (n + 2) + j);
                    for (int[] d : directions) map[i + d[0]][j + d[1]]++;
                }
            }
        }

        char[][] ans = new char[n + 2][n + 2];
        boolean fail = false;
        for (int i = 1; i <= n; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 1; j <= n; j++) {
                if (c[j - 1] == 'x') {
                    if (map[i][j] < 0) {
                        fail = true;
                    } else {
                        ans[i][j] = (char) (map[i][j] + '0');
                    }
                } else {
                    ans[i][j] = '.';
                }
            }
        }

        if (fail) {
            for (Integer ij : mines) {
                int i = ij / (n + 2), j = ij % (n + 2);
                ans[i][j] = '*';
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                bw.write(ans[i][j]);
            }
            bw.newLine();
        }
        bw.flush();
    }
}
