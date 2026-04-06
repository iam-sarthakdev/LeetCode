class Solution:
    def answerQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        nums.sort()

        prefix = []

        s = 0

        for num in nums:
            s += num
            prefix.append(s)

        res = []
        for q in queries:
            res.append(bisect_right(prefix,q))

        return  res       