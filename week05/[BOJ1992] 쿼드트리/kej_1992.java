package algo;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class kej_1992 {
    static int N;
    static int[][] arr;

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s;
    N = Integer.parseInt(br.readLine());

    arr = new int[N][N];

    for (int i = 0; i < N; i++) { // �迭 �Է�
        s = br.readLine();
        for (int j = 0; j < N; j++) {
            arr[i][j] = s.charAt(j) - '0';
        }
    }

    check(0, 0, N);
    System.out.println(sb);
}

static StringBuilder sb = new StringBuilder();

static void check(int a, int b, int size) {
    int flag = 0;
    int num = arr[a][b];
    int check_x = a;
    int check_y = b;

    for (int i = a; i < a + size; i++) {
        for (int j = b; j < b + size; j++) {
            if (arr[i][j] != num) { // üũ �� ���� ������� �ٸ��� ���� �����Ұܤ�
                check_x = i;
                check_y = j;
                flag = 1;
                break;
            }
        }
        if (flag == 1)
            break;
    }
    if (flag == 0) { // �� ���� �����϶�
        sb.append(num);
        return;
    }

    else if (flag == 1) {
        size = size / 2;
        sb.append("(");

        check(a, b, size); // ���� ��
        check(a, b + size, size); // ������ ��
        check(a + size, b, size); // ���� �Ʒ�
        check(a + size, b + size, size); // ������ �Ʒ�

        sb.append(")");
    }

}
}