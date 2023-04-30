import java.io.*;
import java.util.StringTokenizer;

public class kh5676 {

    static int[] tree;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String line;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

            a = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) a[i] = Integer.parseInt(st.nextToken());

            int height = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
            tree = new int[1 << height];
            init(1, 1, N);

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                if (st.nextToken().equals("C")) {
                    int i = Integer.parseInt(st.nextToken());
                    int V = Integer.parseInt(st.nextToken());
                    update(1, 1, N, i, V);
                } else {
                    int i = Integer.parseInt(st.nextToken());
                    int j = Integer.parseInt(st.nextToken());
                    int res = query(1, 1, N, i, j);
                    bw.write(res == 0 ? '0' : res < 0 ? '-' : '+');
                }
            }
            bw.newLine();
        }
        bw.flush();
    }

    static void init(int node, int start, int end) {
        int mid = (start + end) / 2;

        if (start == end) {
            tree[node] = a[mid];
            if (tree[node] != 0) tree[node] /= Math.abs(tree[node]);
            return;
        }

        init(node * 2, start, mid);
        init(node * 2 + 1, mid + 1, end);
        tree[node] = tree[node * 2] * tree[node * 2 + 1];
    }

    static void update(int node, int start, int end, int idx, int val) {
        int mid = (start + end) / 2;

        if (start == end) {
            tree[node] = val;
            if (tree[node] != 0) tree[node] /= Math.abs(tree[node]);
            return;
        }

        if (idx <= mid) update(node * 2, start, mid, idx, val);
        else update(node * 2 + 1, mid + 1, end, idx, val);
        tree[node] = tree[node * 2] * tree[node * 2 + 1];
    }

    static int query(int node, int start, int end, int left, int right) {
        if (start == left && end == right) return tree[node];

        int mid = (start + end) / 2;

        if (right <= mid) return query(node * 2, start, mid, left, right);
        else if (mid < left) return query(node * 2 + 1, mid + 1, end, left, right);
        else return query(node * 2, start, mid, left, mid) * query(node * 2 + 1, mid + 1, end, mid + 1, right);
    }
}
