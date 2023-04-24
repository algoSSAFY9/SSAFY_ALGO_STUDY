import java.io.*;
import java.util.*;

public class kh7432 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Trie trie = new Trie();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] path = br.readLine().split("\\\\");
            trie.add(path);
        }

        trie.traversal();
    }
}

class Trie {

    Node root;

    Trie() {
        root = new Node(null, -1);
    }

    void add(String[] path) {
        Node node = root;
        for (int i = 0; i < path.length; i++) {
            if (!node.child.containsKey(path[i])) node.child.put(path[i], new Node(path[i], i));
            node = node.child.get(path[i]);
        }
    }

    void traversal() {
        StringBuilder sb = new StringBuilder();

        Stack<Node> stack = new Stack<>();
        stack.addAll(root.child.values());
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            sb.append(" ".repeat(node.depth)).append(node.str).append("\n");
            for (Node c : node.child.values()) {
                stack.push(c);
            }
        }

        System.out.println(sb);
    }
}

class Node {
    TreeMap<String, Node> child;
    String str;
    int depth;

    Node(String str, int depth) {
        child = new TreeMap<>(Comparator.reverseOrder());
        this.str = str;
        this.depth = depth;
    }
}
