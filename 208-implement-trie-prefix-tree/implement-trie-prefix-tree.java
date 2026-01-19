class Trie {
    TrieNode head;
    public Trie() {
        head = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode root = head;
        for(char ele: word.toCharArray()) {
            if(root.next[ele-'a'] == null) {
                root.next[ele-'a'] = new TrieNode();
            }
            root = root.next[ele-'a'];
        }
        root.word = true;
    }
    
    public boolean search(String word) {
        TrieNode root = head;
        for(char ele: word.toCharArray()) {
            if(root.next[ele-'a'] == null) {
                return false;
            }
            root = root.next[ele-'a'];
        }
        return root.word;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode root = head;
        for(char ele: prefix.toCharArray()) {
            if(root.next[ele-'a'] == null) {
                return false;
            }
            root = root.next[ele-'a'];
        }
        return true;
    }
}

class TrieNode {
    boolean word;
    TrieNode[] next;

    TrieNode() {
        this.word = false;
        next = new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */