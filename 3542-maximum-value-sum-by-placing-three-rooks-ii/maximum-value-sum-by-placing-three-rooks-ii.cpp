class Solution {
public:
    long long dp[502][502];
    long long helper(int row, int prev2, int prev1, vector<vector<pair<long long,int>>> &grid){
        if(row>=grid.size()) return -1e18;
        if(dp[row][prev1+1]!=-1) return dp[row][prev1+1];
        
		// not placing rook in the current row.
        long long ans = helper(row+1, prev2, prev1, grid);
        
		// place rook in any of the best three columns of the current row.
        for(int col=0; col<3; col++){
            if(grid[row][col].second!=prev2 && grid[row][col].second!=prev1){
                if(prev1!=-1) ans=max(ans,  grid[row][col].first);
                else ans = max(ans, grid[row][col].first + helper(row+1, prev2, grid[row][col].second, grid));
            }
        }
        
        return dp[row][prev1+1]=ans;
    }
    long long maximumValueSum(vector<vector<int>>& board) {
        int n=board.size();
        int m=board[0].size();

		// Create a new grid grid of pairs where each element is a pair (value, column_index).
        vector<vector<pair<long long,int>>> grid(n, vector<pair<long long,int>> (m));
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                grid[i][j]=make_pair(board[i][j], j);
            }
        }
        
		// Sort each row of grid in descending order based on the value. 
		// This ensures that the highest values in each row are considered first.
        for(int i=0; i<n;i++){
            sort(grid[i].rbegin(), grid[i].rend());
        }
        
		// Sort the entire grid in descending order based on the first element of each row. 
		// This prioritizes the most valuable rows.
        sort(grid.rbegin(), grid.rend());
        
		long long ans=-1e18;
        for(int col=0; col<3; col++){
            memset(dp, -1, sizeof(dp));
            ans = max(ans ,grid[0][col].first + helper(1, grid[0][col].second, -1, grid));
        }
        return ans;
    }
};