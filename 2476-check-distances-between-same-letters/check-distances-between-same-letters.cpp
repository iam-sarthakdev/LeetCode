class Solution {
public:
    bool checkDistances(string s, vector<int>& distance) {
        unordered_map<char, int> mp;
        int n = s.size();
        for (int i = 0; i < n; i++) {
            if (!mp.contains(s[i]))
                mp[s[i]] = i;
            else {
                mp[s[i]] = i - mp[s[i]] - 1;
            }
        }

        bool flag = true;

        for (auto& it : mp) {
            if (distance[it.first - 'a'] != it.second) {
                flag = false;
                break;
            }
        }
        return flag;
    }
};