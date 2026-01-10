class Solution {
    public boolean lemonadeChange(int[] bills) {
        int changeFive = 0;
        int changeTen = 0;
        for(int bill : bills){
            if(bill == 5){
                changeFive++;
            }else if(bill == 10){
                changeTen++;
                if(changeFive <= 0) return false;
                changeFive--;
            }else{
                if(changeFive >= 1 && changeTen >= 1){
                    changeTen--;
                    changeFive--;
                }else{
                    if(changeFive < 3) return false;
                    changeFive -= 3;
                }
                }
            }
            return true;
        }
    }