package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class kej2580 {
	static int[][] arr = new int[9][9];
	static List<Point> idx = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0)
					idx.add(new Point(i, j));
			}
		}

		Sudoku(0);
		System.out.println(sb);
	}

	static StringBuilder sb = new StringBuilder();
	static boolean complete = false;

	static void Sudoku(int a) {
		if(complete) return;
		if (a == idx.size()) {
			complete = true;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
			return;
		}

		int x = idx.get(a).x;
		int y = idx.get(a).y;

		boolean[] visit = new boolean[10];

		// ����
		for (int i = 0; i < 9; i++) {
			if (arr[x][i] != 0)
				visit[arr[x][i]] = true;
		}

		// ����
		for (int i = 0; i < 9; i++) {
			if (arr[i][y] != 0)
				visit[arr[i][y]] = true;
		}

		// �׸�
		int dx = (x / 3) * 3;
		int dy = (y / 3) * 3;
		for (int i = dx; i < dx + 3; i++) {
			for (int j = dy; j < dy + 3; j++) {
				if (arr[i][j] != 0)
					visit[arr[i][j]] = true;
			}
		}

		for (int i = 1; i <= 9; i++) {
			if (visit[i])
				continue; // �湮�ߴ�? ��������
			arr[x][y] = i; // �湮 �������� �湮�ϰ� ���� ������ ���� ���߷� ����
			Sudoku(a + 1); // ���� �������� �´� ���ڰ� �ȳ�����
			arr[x][y] = 0; // return�ؼ� �湮���� �������� �湮
		}
	}

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
