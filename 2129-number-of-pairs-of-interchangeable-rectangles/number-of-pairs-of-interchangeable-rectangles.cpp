class Solution {
public:
    long long interchangeableRectangles(vector<vector<int>>& arr) {
        for (int i=0 ; i<arr.size() ; i++){
            int gcd=__gcd(arr[i][0],arr[i][1]);
            arr[i][0]/=gcd;
            arr[i][1]/=gcd;
        }
        sort(arr.begin(),arr.end());
        long long ans=0 , cnt=1;
        for (int i=1 ; i<arr.size() ; i++){
            if (arr[i][0]==arr[i-1][0] && arr[i][1]==arr[i-1][1]){
                cnt++;
            }
            else{
                ans+=(cnt*(cnt-1))/2;
                cnt=1;
            }
        }
        ans+=(cnt*(cnt-1))/2;
        return ans;
    }
};