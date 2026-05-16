class Solution {
public:
    vector<int> rowAndMaximumOnes(vector<vector<int>>& mat) {
        vector<int> ans(2, -1);
        int rows = mat.size();
        int cols = mat[0].size();
        for (int i = 0; i < rows; i++) {
            int countCurrOnes = 0;
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1)
                    countCurrOnes++;
            }
            if (ans[1] < countCurrOnes) {
                ans[0] = i;
                ans[1] = countCurrOnes;
            }
        }

        return ans;
    }
};