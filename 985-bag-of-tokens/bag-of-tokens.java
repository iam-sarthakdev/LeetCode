class Solution {
    public int bagOfTokensScore(int[] tokens, int power){
        Arrays.sort(tokens);
        int currScore = 0;
        int maxScore = 0;

        int left = 0;
        int right = tokens.length - 1;

        while(right >= left){
            if(tokens[left] <= power){
                power -= tokens[left];
                currScore++;
                maxScore = Math.max(maxScore, currScore);
                left++;
            }else if(currScore == 0){
                if(power >= tokens[left]){
                    power -= tokens[left];
                    currScore++;
                    maxScore = Math.max(maxScore, currScore);
                    left++;
                }else return maxScore;
                }else if(currScore > 0){
                    power += tokens[right];
                    currScore--;
                    right--;
                }
            }
            return maxScore;
        }
    }