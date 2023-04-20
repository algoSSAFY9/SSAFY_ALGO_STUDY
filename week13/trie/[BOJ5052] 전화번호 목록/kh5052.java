import java.io.*;

public class kh5052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] phone = new String[n];
            for (int i = 0; i < n; i++) phone[i] = br.readLine();

            Trie trie = new Trie();
            boolean valid = true;
            for (int i = 0; i < n; i++) {
                if (!trie.add(phone[i])) {
                    valid = false;
                    break;
                }
            }

            bw.write(valid ? "YES" : "NO");
            bw.newLine();
        }
        bw.flush();
    }
}

class Trie {

    Node root;

    Trie() {
        root = new Node();
    }

    boolean add(String str) {
        Node node = root;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (node.exist) return false;

            node.n++;
            int idx = str.charAt(i) - '0';
            if (node.child[idx] == null) node.child[idx] = new Node();
            node = node.child[idx];
        }

        if (node.n > 0) return false;

        node.exist = true;
        return true;
    }
}

class Node {
    boolean exist;
    Node[] child;
    int n;

    Node() {
        exist = false;
        child = new Node[10];
        n = 0;
    }
}
