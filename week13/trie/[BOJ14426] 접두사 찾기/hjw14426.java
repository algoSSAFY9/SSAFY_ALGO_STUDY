import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hjw14426 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Trie trie = new Trie();
		for (int i = 0; i < N; i++) {
			trie.add(br.readLine());
		}

		int res = 0;
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (trie.isPrefix(str)) {
				res++;
			}
		}
		System.out.println(res);
	}

	static class Trie {
		TrieNode trieNode;

		Trie() {
			trieNode = new TrieNode();
		}

		void add(String str) {
			TrieNode node = trieNode;

			for (int i = 0; i < str.length(); i++) {
				int idx = str.charAt(i) - 'a';
				if (node.child[idx] == null) {
					node.child[idx] = new TrieNode();
				}
					
				node = node.child[idx];
			}
			node.exist = true;
		}

		boolean isPrefix(String str) {
			TrieNode node = trieNode;
			for (int i = 0; i < str.length(); i++) {
				int idx = str.charAt(i) - 'a';
				if (node.child[idx] == null) {
					return false;
				}
				node = node.child[idx];
			}
			return true;
		}
	}

	static class TrieNode {
		boolean exist;
		TrieNode[] child;

		TrieNode() {
			exist = false;
			child = new TrieNode[26];
		}
	}
}