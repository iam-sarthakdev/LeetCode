class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, "", 0, 0, res);
        return res;
    }
    private void backtrack(int n, String curr, int open, int close, List<String> res){
        if(curr.length() == 2*n){
            res.add(curr);
            return;
        }
        if(open < n){
            backtrack(n, curr + "(", open +1, close, res);
        }
        if(close < open){
            backtrack(n, curr + ")", open, close+1, res);
        }
    }
}