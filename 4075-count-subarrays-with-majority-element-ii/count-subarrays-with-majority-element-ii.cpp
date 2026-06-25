class Solution {
public:
    #define ll long long
    #define debug(x) cout<<#x<<" is: "<<x<<endl;
    #define mx 200050
    #define shift 100003
    vector<int> seg;

    void update(int l,int r,int idx,int ind,int val){
        //ind per +val karo
        if(l==r){
            seg[idx] += val;
            return;
        }
        int mid = (l+r)/2;
        if(ind<=mid){
            update(l,mid,2*idx+1,ind,val);
        }else{
            update(mid+1,r,2*idx+2,ind,val);
        }
        seg[idx] = seg[2*idx+1]+seg[2*idx+2];
    }

    int query(int l,int r,int idx,int left,int right){
        //left se right tak ka sm
        if(left<=l && r<=right) return seg[idx];
        if(left>r || right<l) return 0;

        int mid = (l+r)/2;
        int ans = query(l,mid,2*idx+1,left,right)+query(mid+1,r,2*idx+2,left,right);
        return ans;
    }
    
    long long countMajoritySubarrays(vector<int>& nums, int target) {
        int n = nums.size();
        for(int i=0; i<n; i++){
            if(nums[i]==target) nums[i] = 1;
            else nums[i] = -1;
        }
        //>0 value subarray
        ll ans = 0;
        seg.resize(4*mx,0);
        ll sm = 0;
        //0 pahle se hi daal do
        update(0,mx-1,0,0+shift,1);
        for(int i=0; i<n; i++){
            sm += nums[i];
            //find sum in segment tree
            //-shift to sm-1+shift
            ll val = 0;
            val = query(0,mx-1,0,-shift,sm-1+shift);
            ans += val;
            update(0,mx-1,0,sm+shift,1);
            
        }
        
        return ans;
    }
};