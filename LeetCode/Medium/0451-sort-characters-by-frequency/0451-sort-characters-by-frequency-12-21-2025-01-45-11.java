class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){

            pq.offer(new int[]{entry.getKey(),entry.getValue()});
        }

        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty()){
            int count = pq.peek()[1];
            char curr = (char)pq.poll()[0];
            while(count-- > 0){
                ans.append(curr);
            }
        }
        return ans.toString();
    }
}