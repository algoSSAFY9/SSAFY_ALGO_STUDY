import java.io.*;
import java.util.StringTokenizer;

public class kh11505 {

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

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            if (C == 1) {
                int A = Integer.parseInt(st.nextToken());
                long B = Long.parseLong(st.nextToken());
                update(tree, 1, 1, N, A, B);
            } else {
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                bw.write(String.valueOf(query(tree, 1, 1, N, A, B)));
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

        tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % 1000000007;
    }

    static long query(long[] tree, int node, int start, int end, int left, int right) {
        if (start == left && end == right) return tree[node];

        int mid = (start + end) / 2;

        if (right <= mid) return query(tree, node * 2, start, mid, left, right);
        else if (mid < left) return query(tree, node * 2 + 1, mid + 1, end, left, right);
        else return (query(tree, node * 2, start, mid, left, mid) * query(tree, node * 2 + 1, mid + 1, end, mid + 1, right)) % 1000000007;
    }

    static void update(long[] tree, int node, int start, int end, int idx, long val) {
        if (start == end) {
            tree[node] = val;
            return;
        }

        int mid = (start + end) / 2;

        if (idx <= mid) update(tree, node * 2, start, mid, idx, val);
        else update(tree, node * 2 + 1, mid + 1, end, idx, val);

        tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % 1000000007;
    }
}
