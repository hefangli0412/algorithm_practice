// 208. Implement Trie (Prefix Tree)
// https://leetcode.com/problems/implement-trie-prefix-tree/

/* The root of the Trie is an empty character. When following a path in the Trie,
  the current character should be a child node of the current node.
  
  No need to store character at TrieNode. c.next[i] != null is enough.
  
  Refer to https://leetcode.com/discuss/46959/ac-java-solution-simple-using-single-array.
*/

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
    
    // Initialize your data structure here.
    public TrieNode() {}
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
        }
        cur.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
        }
        return cur.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
