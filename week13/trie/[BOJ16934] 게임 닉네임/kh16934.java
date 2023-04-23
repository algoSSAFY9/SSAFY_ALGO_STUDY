import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kh16934 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Trie trie = new Trie();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String nickname = br.readLine();
            trie.add(nickname, sb);
        }

        System.out.println(sb);
    }
}

class Trie {

    Node root;

    Trie() {
        root = new Node();
    }

    void add(String nickname, StringBuilder sb) {
        Node node = root;
        boolean alias = false;
        for (int i = 0; i < nickname.length(); i++) {
            if (!alias) sb.append(nickname.charAt(i));

            int idx = nickname.charAt(i) - 'a';
            if (node.child[idx] == null) {
                if (!alias) alias = true;
                node.child[idx] = new Node();
            }
            node = node.child[idx];
        }

        node.count++;
        if (!alias && node.count >= 2) sb.append(node.count);
        sb.append("\n");
    }
}

class Node {

    int count;
    Node[] child;

    Node() {
        count = 0;
        child = new Node[26];
    }
}
