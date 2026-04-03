class Solution {
    class Node{
        Node[] links = new Node[26];
        String word = null;
    }
    private Node root = new Node();
    
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
        node.word = word;
        
    }

    public List<String> findWords(char[][] board, String[] words) {

        for(String word : words){
            insert(word);
        }
        
        int m = board.length;
        int n = board[0].length;
        List<String> result = new ArrayList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(board, i, j, root, result);
            }
        }
        
        return result;
    }

    private void dfs(char[][] board, int i, int j, Node node, List<String> result){
        char ch = board[i][j];
        int index = ch - 'a';
        // base case
        if(ch == '#' || node.links[index] == null){
            return;
        }
        node = node.links[ch - 'a'];

        if(node.word != null){
            result.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        // explore 4 dirn 
        if(i > 0) dfs(board, i - 1, j , node, result);
        if(j > 0) dfs(board, i, j-1 , node, result);
        if(i < board.length - 1) dfs(board, i + 1, j , node, result);
        if(j < board[0].length - 1) dfs(board, i, j + 1 , node, result);

        // backtrack 
        board[i][j] = ch;
    }
}