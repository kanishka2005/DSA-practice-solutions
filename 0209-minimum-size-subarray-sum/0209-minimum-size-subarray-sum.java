class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low = 0;
        int high = 0;
        int Sum = 0;
        int result = Integer.MAX_VALUE;

        while(high<nums.length){
            Sum += nums[high];

            while(Sum >= target) {
                result = Math.min(result,high-low+1);
                Sum -= nums[low];
                low++;
            }
            high++;
        }
        return result == Integer.MAX_VALUE ? 0: result;
    }
}