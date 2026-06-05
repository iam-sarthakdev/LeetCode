class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, res, new ArrayList<>(), 0);
        return res;
    }
    private void backtrack(String s, List<List<String>> res, List<String> curr, int start){
        if(start == s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int end = start; end < s.length(); end++){
            if(isPalindrome(s, start, end)){
                curr.add(s.substring(start, end + 1));

                backtrack(s, res, curr, end+1);

                curr.remove(curr.size() -1);
            }
        }
    }
    private boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}