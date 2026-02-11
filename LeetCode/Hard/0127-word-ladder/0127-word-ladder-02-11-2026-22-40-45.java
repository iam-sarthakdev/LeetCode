class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;

        // setup queue
        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        int level = 1;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                String word = q.poll();
                if(word.equals(endWord)) return level;

                char[] chars = word.toCharArray();

                for(int j = 0; j < chars.length; j++){
                    char original = chars[j];

                    for(char c = 'a'; c <= 'z'; c++){
                        chars[j] = c;

                        String temp = new String(chars);

                        if(set.contains(temp)){
                            q.add(temp);
                            set.remove(temp);
                        }
                    }
                    chars[j] = original;
                }
            }
            level++;
        }
        return 0;
    }
}