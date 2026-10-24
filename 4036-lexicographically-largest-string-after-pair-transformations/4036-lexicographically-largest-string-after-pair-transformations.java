class Solution {
    public String[] largestString(int[] nums) {
        int n = nums.length;
        String[] ans = new String[n];
        
        for (int i = 0; i < n; i++) {
            long x = nums[i];
            StringBuilder sb = new StringBuilder();
            
            // k = 26 represents "zz" (weight 2^26)
            // k = 25 down to 0 represents characters 'z' down to 'a' (weight 2^k)
            for (int k = 26; k >= 0; k--) {
                long weight = (1L << k);
                
                if (x >= weight) {
                    long count = x / weight;
                    x %= weight;
                    
                    if (k == 26) {
                        // Append 'count' number of "zz" blocks
                        for (long c = 0; c < count; c++) {
                            sb.append("zz");
                        }
                    } else {
                        // Append 'count' number of the corresponding character ('a' + k)
                        char ch = (char) ('a' + k);
                        for (long c = 0; c < count; c++) {
                            sb.append(ch);
                        }
                    }
                }
            }
            ans[i] = sb.toString();
        }
        
        return ans;
    }
}