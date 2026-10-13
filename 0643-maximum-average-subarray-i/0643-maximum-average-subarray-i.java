class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int low = 0;
        int high = 0;
        double currentSum = 0;
        
        // Step 1: Pehli window banane ke liye high ko k tak chalate hain
        while (high < k) {
            currentSum += nums[high];
            high++;
        }
        
        double maxSum = currentSum;
        
        // Step 2: Window ko aage slide karne ke liye loop
        while (high < nums.length) {
            currentSum = currentSum + nums[high] - nums[low];
            maxSum = Math.max(maxSum, currentSum);
            
            low++;
            high++;
        }
        
        // Step 3: Maximum average return karo
        return maxSum / k;
    }
}