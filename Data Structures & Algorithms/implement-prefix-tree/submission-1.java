class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        node.pass++;
        for(char c : word.toCharArray()){
            int path = c - 'a';
            if(node.nexts[path] == null){
                node.nexts[path] = new TrieNode();
            } 
            node = node.nexts[path];
            node.pass++;
        }
        node.end++;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int path = c - 'a';
            if(node.nexts[path] == null){
                return false;
            }
            node = node.nexts[path];
        }
        return node.end > 0;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char c : prefix.toCharArray()){
            int path = c - 'a';
            if(node.nexts[path] == null){
                return false;
            }
            node = node.nexts[path];
        }
        return true;
    }
}

class TrieNode {
    public int pass;
    public int end;
    public TrieNode[] nexts;

    public TrieNode() {
        pass = 0;
        end = 0;
        nexts = new TrieNode[26];
    }
}
