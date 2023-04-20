import java.io.*;
import java.util.StringTokenizer;

public class kh14426 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();
        for (int i = 0; i < N; i++) trie.add(br.readLine());

        int ans = 0;
        for (int i = 0; i < M; i++) {
            if (trie.isPrefix(br.readLine())) {
                ans++;
            }
        }
        bw.write(String.valueOf(ans));
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
        }
        node.exist = true;
    }

    boolean isPrefix(String str) {
        Node node = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (node.child[idx] == null) return false;
            node = node.child[idx];
        }
        return true;
    }
}

class Node {
    boolean exist;
    Node[] child;

    Node() {
        exist = false;
        child = new Node[26];
    }
}
