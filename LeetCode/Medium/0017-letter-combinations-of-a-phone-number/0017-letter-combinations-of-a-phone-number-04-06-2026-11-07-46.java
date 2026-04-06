class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        backtrack(res, digits, 0, "", map);
        return res;
    }
    private void backtrack(List<String> res, String digits, int index, String curr, String[] map){
        if(index == digits.length()){
            res.add(curr);
            return;
        }
        String letters = map[digits.charAt(index) - '0'];
        
        for(char ch : letters.toCharArray()){
            curr += ch;
            backtrack(res, digits, index+1, curr, map);
            curr = curr.substring(0, curr.length()- 1);
        }
    }
}