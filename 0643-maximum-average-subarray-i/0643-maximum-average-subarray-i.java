class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double currentSum = 0;
        
        // Step 1: Pehli window ka sum calculate karo
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        
        double maxSum = currentSum;
        
        // Step 2: Single loop se window ko slide karo (no extra variables needed)
        for (int i = k; i < nums.length; i++) {
            currentSum = currentSum + nums[i] - nums[i - k];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        
        // Step 3: Result return karo
        return maxSum / k;
    }
}