import java.io.*;
import java.util.StringTokenizer;

public class kh10868 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());

        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int tree_size = (1 << (h + 1));
        int[] tree = new int[tree_size];
        init(arr, tree, 1, 1, N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(query(tree, 1, 1, N, A, B)));
            bw.newLine();
        }
        bw.flush();
    }

    static void init(int[] arr, int[] tree, int node, int start, int end) {
        int mid = (start + end) / 2;

        if (start == end) {
            tree[node] = arr[mid];
            return;
        }

        init(arr, tree, node * 2, start, mid);
        init(arr, tree, node * 2 + 1, mid + 1, end);

        tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
    }

    static int query(int[] tree, int node, int start, int end, int left, int right) {
        if (start == left && end == right) return tree[node];

        int mid = (start + end) / 2;

        if (right <= mid) return query(tree, node * 2, start, mid, left, right);
        else if (mid < left) return query(tree, node * 2 + 1, mid + 1, end, left, right);
        else return Math.min(query(tree, node * 2, start, mid, left, mid), query(tree, node * 2 + 1, mid + 1, end, mid + 1, right));
    }
}
