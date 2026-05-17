class Solution {
public:
    int maxDepth(string s) {
        int count = 0;
        int res = 0;

        for(char i : s) {
            if(i == '(') {
                count++;
                res = max(res, count);
            }
            else if(i == ')') {
                count--;
            }
        }

        return res;
    }
};