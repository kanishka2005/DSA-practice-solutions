class Solution {
    public double myPow(double a, int n) {
        // 1. n ko long mein convert karenge taaki -2147483648 waala overflow na ho
        long N = n;
        
        // 2. AGAR POWER NEGATIVE HAI: toh base ko ulta (1/a) kar do aur power ko positive (+N)
        if (N < 0) {
            a = 1 / a;
            N = -N;
        }
        
        double ans = 1.0;
        
        // 3. Aapka sikha hua original logic (ab N ke saath chalega)
        while (N > 0) {
            if ((N & 1) != 0) {
                ans = ans * a;
            }
            a = a * a;
            N = N >> 1;
        }
        
        return ans;
    }
}