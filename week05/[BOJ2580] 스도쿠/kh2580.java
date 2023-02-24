import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class kh2580 {

    static int[][] sudoku;
    static ArrayList<int[]> blanks;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        sudoku = new int[9][9];
        blanks = new ArrayList<>();
        visited = new boolean[3][9][10];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
                if (sudoku[i][j] == 0) blanks.add(new int[]{i, j});
                else
                    visited[0][i][sudoku[i][j]] = visited[1][j][sudoku[i][j]] = visited[2][i / 3 * 3 + j / 3][sudoku[i][j]] = true;
            }
        }

        solution(0);

        for (int[] ints : sudoku) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static boolean solution(int idx) {
        if (idx == blanks.size()) return true;

        int[] rc = blanks.get(idx);
        for (int i = 1; i <= 9; i++) {
            if (!visited[0][rc[0]][i] && !visited[1][rc[1]][i] && !visited[2][rc[0] / 3 * 3 + rc[1] / 3][i]) {
                visited[0][rc[0]][i] = visited[1][rc[1]][i] = visited[2][rc[0] / 3 * 3 + rc[1] / 3][i] = true;
                sudoku[rc[0]][rc[1]] = i;
                if (solution(idx + 1)) return true;
                visited[0][rc[0]][i] = visited[1][rc[1]][i] = visited[2][rc[0] / 3 * 3 + rc[1] / 3][i] = false;
            }
        }
        return false;
    }
}
