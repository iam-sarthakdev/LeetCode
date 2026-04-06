from collections import deque

class Solution:
    def maximumRobots(self, chargeTimes: List[int], runningCosts: List[int], budget: int) -> int:
        n = len(chargeTimes)
        max_dq = deque()  # Maintains indices for max(chargeTimes)
        running_sum = 0
        left = 0
        max_k = 0
        
        for right in range(n):
            # 1. Update running cost (The Linear Sum part of the LP)
            running_sum += runningCosts[right]
            
            # 2. Update max charge (The Non-linear 'max' constraint)
            while max_dq and chargeTimes[max_dq[-1]] <= chargeTimes[right]:
                max_dq.pop()
            max_dq.append(right)
            
            # 3. Feasibility Check: max(C) + k * sum(R) <= Budget
            # If infeasible, we 'relax' the constraint by moving the left boundary
            while max_dq and (chargeTimes[max_dq[0]] + (right - left + 1) * running_sum) > budget:
                running_sum -= runningCosts[left]
                if max_dq[0] == left:
                    max_dq.popleft()
                left += 1
            
            # 4. Update the objective: maximize window size k
            max_k = max(max_k, right - left + 1)
            
        return max_k        