class WordDictionary {
    class Node{
        Node[] links = new Node[26];
        boolean isEnd = false;
    }
    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(node.links[index] == null){
                node.links[index] = new Node();
            }
            node = node.links[index];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    private boolean dfs(String word, int index, Node node){
        if(index == word.length()) return node.isEnd;

        char ch = word.charAt(index);

        // case 1
        if(ch != '.'){
            int i = ch - 'a';
            if(node.links[i] == null) return false;
            return dfs(word, index+1, node.links[i]);
        }else{ // ch == .
            for(int i = 0; i < 26; i++){
                if(node.links[i] != null){
                    if(dfs(word, index+1,  node.links[i])) return true;
                }
            }
            return false;
        }
    }
}
