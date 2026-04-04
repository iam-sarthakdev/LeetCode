class Solution {
public:
    vector<long long> findPrefixScore(vector<int>& nums) {

        int n = nums.size();
        vector<long long> ans(n, 0);
        ans[0] = 2 * nums[0];
        int maxEle = nums[0];

        for (int i = 1; i < n; i++) {
            maxEle = max(nums[i], maxEle);
            ans[i] = ans[i - 1] + (nums[i] + maxEle);
        }

        return ans;
    }
};