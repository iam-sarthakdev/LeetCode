import java.util.*;

public class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        
        int remainder = 0; // stores current prefix value modulo 5
        
        for (int bit : nums) {
            // Update remainder using binary shifting logic
            remainder = (remainder * 2 + bit) % 5;
            
            // If remainder becomes 0, the prefix is divisible by 5
            result.add(remainder == 0);
        }
        
        return result;
    }
}