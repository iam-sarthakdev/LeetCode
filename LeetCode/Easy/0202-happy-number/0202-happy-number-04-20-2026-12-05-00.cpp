class Solution {
public:
    bool isHappy(int n) {
        auto next = [](int n)->int{
            int sum = 0;
            while(n){
                int x = n % 10;
                sum += x * x;
                n /= 10;
            }
            return sum;
        };

        int slow = n, fast = n;

        while(fast != 1 && next(fast) != 1){
            slow = next(slow);
            fast = next(next(fast));

            if(slow == fast){
                return false;
            }
        }

        return true;
    }
};