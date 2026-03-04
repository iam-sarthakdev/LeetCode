class Solution {
public:
    int minDeletion(string s, int k) {
        unordered_map<char, int> mpp;

        // Count frequency of each character
        for (char c : s) {
            mpp[c]++;
        }

        // Store frequencies
        vector<int> freq;
        for (auto it : mpp) {
            freq.push_back(it.second);
        }

        // Sort frequencies in ascending order
        sort(freq.begin(), freq.end());

        int cnt = 0;
        int n = freq.size();

        // Remove smallest frequencies until only k remain
        for (int i = 0; i < n - k; i++) {
            cnt += freq[i];
        }

        return cnt;
    }
};