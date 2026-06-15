class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length() != words.length) return false;

        Map<Character, String> mapP = new HashMap<>();
        Map<String, Character> mapS = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++){
            char P = pattern.charAt(i);
            String ss = words[i];

            if(mapP.containsKey(P)){
                if(!mapP.get(P).equals(ss)) return false;
            }else{ // not mapped 
            if(mapS.containsKey(ss)) return false;
            }
            mapP.put(P, ss);
            mapS.put(ss, P);
        }
        return true;

    }
}