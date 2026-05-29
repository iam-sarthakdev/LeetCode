class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(n, k, res, list, 1);
        return res;
    }
    private void helper(int n, int k, List<List<Integer>> res,  List<Integer> list, int start){

        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }

        if(start > n) return;
        // take current element and explore
        list.add(start);
        helper(n, k, res, list, start + 1);
        
        // bacltrack
        list.remove(list.size()-1);

        // skip
         helper(n, k, res, list, start + 1);
    }
}