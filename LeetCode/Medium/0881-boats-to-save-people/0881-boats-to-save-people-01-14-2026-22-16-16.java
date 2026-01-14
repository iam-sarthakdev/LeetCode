class Solution {
    public int numRescueBoats(int[] people, int limit) {
       Arrays.sort(people);
       int boats = 0;
       int left = 0;
       int right = people.length - 1;

       while(right > left){
        if(people[right] == limit){
            people[right] = -people[right];
            boats++;
            right--;
        }else if(people[left] + people[right] <= limit){
            people[left] = -people[left];
            people[right] = -people[right];
            boats++;
            left++;
            right--;
        }else if(people[left] + people[right] > limit){
            right--;
        }
       }
       for(int i = 0; i < people.length; i++){
        if(people[i] > 0) boats++;
       }
       return boats;
    }
}