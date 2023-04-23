import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class kh14725 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Trie trie = new Trie();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            String[] str = new String[K];
            for (int k = 0; k < K; k++) str[k] = st.nextToken();
            trie.add(str);
        }

        trie.traversal(sb);

        System.out.println(sb);
    }
}

class Trie {

    Node root;

    Trie() {
        root = new Node(null, -1);
    }

    void add(String[] str) {
        Node node = root;
        for (int i = 0; i < str.length; i++) {
            if (!node.child.containsKey(str[i])) node.child.put(str[i], new Node(str[i], i));
            node = node.child.get(str[i]);
        }
    }

    public void traversal(StringBuilder sb) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node != root) sb.append("--".repeat(node.depth)).append(node.str).append("\n");
            for (Node child : node.child.values()) stack.push(child);
        }
    }
}

class Node {

    String str;
    int depth;
    TreeMap<String, Node> child;

    Node(String str, int depth) {
        this.str = str;
        this.depth = depth;
        child = new TreeMap<>(Comparator.reverseOrder());
    }
}
