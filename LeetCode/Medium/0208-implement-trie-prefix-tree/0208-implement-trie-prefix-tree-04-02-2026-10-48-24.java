class Trie {
    class Node{
        Node[] links = new Node[26];
        boolean isEnd = false;
    }
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;

        for(char ch : word.toCharArray()){
            int index = ch - 'a';

            if(node.links[index] == null){
                // create new node at that index
                node.links[index] = new Node();
            }
            node = node.links[index];
        }
        node.isEnd = true;
        
    }
    
    public boolean search(String word) {
        Node node = root;

        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(node.links[index] == null) return false;
            node = node.links[index];
        }
        return node.isEnd;
        
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;

        for(char ch : prefix.toCharArray()){
            int index = ch - 'a';
            if(node.links[index] == null) return false;
            node = node.links[index];
        }
        return true;
    }
}
