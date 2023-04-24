import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kh27652 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Trie A = new Trie(), B = new Trie();

        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {

                case "add":
                    if (st.nextToken().equals("A")) A.add(st.nextToken());
                    else B.add(new StringBuilder(st.nextToken()).reverse().toString());
                    break;

                case "delete":
                    if (st.nextToken().equals("A")) A.delete(st.nextToken());
                    else B.delete(new StringBuilder(st.nextToken()).reverse().toString());
                    break;

                case "find":
                    String S = st.nextToken();
                    int[] a = A.findPrefix(S);
                    int[] b = B.findPrefix(new StringBuilder(S).reverse().toString());

                    int ans = 0;
                    for (int j = 0; j < S.length() - 1; j++) ans += a[j] * b[b.length - 1 - j];
                    bw.write(String.valueOf(ans));
                    bw.newLine();
                    break;

            }
        }
        bw.flush();
    }
}

class Trie {

    Node root;

    Trie() {
        root = new Node();
    }

    void add(String str) {
        Node node = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (node.child[idx] == null) node.child[idx] = new Node();
            node = node.child[idx];
            node.n++;
        }
    }

    void delete(String str) {
        Node node = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (node.child[idx] == null) node.child[idx] = new Node();
            node = node.child[idx];
            node.n--;
        }
    }

    int[] findPrefix(String str) {
        Node node = root;
        int[] prefix = new int[str.length() - 1];
        for (int i = 0; i < prefix.length; i++) {
            int idx = str.charAt(i) - 'a';
            if (node.child[idx] == null) break;
            node = node.child[idx];
            prefix[i] += node.n;
        }
        return prefix;
    }
}

class Node {
    int n;
    Node[] child;

    Node() {
        n = 0;
        child = new Node[26];
    }
}
