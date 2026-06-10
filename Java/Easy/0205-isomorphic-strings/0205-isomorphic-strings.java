class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map <Character, Character> mapST = new HashMap<>();
        Map <Character, Character> mapTS = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char chs = s.charAt(i);
            char cht = t.charAt(i);

            if(mapST.containsKey(chs)){
                if(mapST.get(chs) != cht) return false;
            }else{
            if(mapTS.containsKey(cht)) return false;
            }
            mapST.put(chs, cht);
            mapTS.put(cht, chs);
        }
        return true;
    }
}