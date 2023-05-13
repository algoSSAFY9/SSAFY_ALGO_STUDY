import java.io.*;
import java.util.StringTokenizer;

public class kh10999 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = Long.parseLong(br.readLine());

        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int tree_size = (1 << (h + 1));
        long[] tree = new long[tree_size];
        init(arr, tree, 1, 1, N);

        long[] lazy = new long[tree_size];
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                long d = Long.parseLong(st.nextToken());
                update(tree, lazy, 1, 1, N, b, c, d);
            } else {
                bw.write(String.valueOf(query(tree, lazy, 1, 1, N, b, c)));
                bw.newLine();
            }
        }
        bw.flush();
    }

    static void init(long[] arr, long[] tree, int node, int start, int end) {
        int mid = (start + end) / 2;

        if (start == end) {
            tree[node] = arr[mid];
            return;
        }

        init(arr, tree, node * 2, start, mid);
        init(arr, tree, node * 2 + 1, mid + 1, end);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static long query(long[] tree, long[] lazy, int node, int start, int end, int left, int right) {
        tree[node] += (end - start + 1) * lazy[node];

        if (start != end) {
            lazy[node * 2] += lazy[node];
            lazy[node * 2 + 1] += lazy[node];
        }

        lazy[node] = 0;

        if (start == left && end == right) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        if (right <= mid) return query(tree, lazy, node * 2, start, mid, left, right);
        else if (mid < left) return query(tree, lazy, node * 2 + 1, mid + 1, end, left, right);
        else return query(tree, lazy, node * 2, start, mid, left, mid) + query(tree, lazy, node * 2 + 1, mid + 1, end, mid + 1, right);
    }

    static void update(long[] tree, long[] lazy, int node, int start, int end, int left, int right, long val) {
        if (start == left && end == right) {
            lazy[node] += val;
            return;
        }

        tree[node] += (right - left + 1) * val;

        int mid = (start + end) / 2;

        if (right <= mid) update(tree, lazy, node * 2, start, mid, left, right, val);
        else if (mid < left) update(tree, lazy, node * 2 + 1, mid + 1, end, left, right, val);
        else {
            update(tree, lazy, node * 2, start, mid, left, mid, val);
            update(tree, lazy, node * 2 + 1, mid + 1, end, mid + 1, right, val);
        }
    }
}
