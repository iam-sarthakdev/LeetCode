class Solution {
    public int numRescueBoats(int[] people, int limit) {
       Arrays.sort(people);
       int boats = 0;
       int left = 0;
       int right = people.length - 1;

       while(right >= left){
        if(people[right] == limit){
            boats++;
            right--;
        }else if(people[left] + people[right] <= limit){
            boats++;
            left++;
            right--;
        }else{
            right--;
            boats++;
        }
        }
       return boats;
    }
}