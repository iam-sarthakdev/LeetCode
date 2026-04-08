class Solution:
    def countKDifference(self, nums: List[int], k: int) -> int:
        mp = Counter(nums)
        return sum(mp[v - k] for v in nums if v - k in mp)