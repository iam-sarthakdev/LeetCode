class Solution {
public:
    int mostFrequentEven(vector<int>& nums) {

        unordered_map<int, int> mp;
        int n = nums.size();
        int hasEvenElements = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                hasEvenElements = 1;
                mp[nums[i]]++;
            }
        }

        if (hasEvenElements == -1)
            return -1;
        int smallestEvenHighestFreq = INT_MAX;
        int prevFreq = -1;
        for (auto& it : mp) {
            if (it.second > prevFreq) {
                prevFreq = it.second;
                smallestEvenHighestFreq = it.first;
            } else if (it.second == prevFreq) {
                smallestEvenHighestFreq =
                    min(smallestEvenHighestFreq, it.first);
            }
        }

        return smallestEvenHighestFreq;
    }
};