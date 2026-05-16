class Solution {
    public void addOne(TreeMap<Integer, Integer> map, int key){
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    public void removeOne(TreeMap<Integer, Integer> map, int key){
        map.put(key, map.get(key) - 1);
        if (map.get(key) == 0) map.remove(key);
    }

    public void bottomToTop(TreeMap<Integer, Integer> top, 
    TreeMap<Integer, Integer> bottom){
        int lowerBound = bottom.firstKey();
        removeOne(bottom, lowerBound);
        addOne(top, lowerBound);
    }

    public void topToBottom(TreeMap<Integer, Integer> top, 
    TreeMap<Integer, Integer> bottom){
        int upperBound = top.lastKey();
        removeOne(top, upperBound);
        addOne(bottom, upperBound);
    }

    public void rebalance(TreeMap<Integer, Integer> top, 
    TreeMap<Integer, Integer> bottom){
        bottomToTop(top, bottom);
        topToBottom(top, bottom);
    }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        // sliding window + treeMaps
        int len = nums.length, size = 0;
        int[] beauty = new int[len - k + 1];
        TreeMap<Integer, Integer> top = new TreeMap<>();
        TreeMap<Integer, Integer> bottom = new TreeMap<>();

        for (int i = 0; i < len; i++){
            int add = nums[i];
            if (add < 0){
                if (size < x){
                    size++;
                    addOne(top, add);
                }else{
                    addOne(bottom, add);
                    rebalance(top, bottom);
                }
            }

            if (i + 1 < k) continue;
            beauty[i - k + 1] = size < x ? 0 : top.lastKey();
            int remove = nums[i - k + 1];
            
            if (remove < 0){
                if (top.containsKey(remove)){
                    removeOne(top, remove);
                    if (bottom.isEmpty()) size--;
                    else bottomToTop(top, bottom);
                }else removeOne(bottom, remove);
            }
        }

        return beauty;
    }
}