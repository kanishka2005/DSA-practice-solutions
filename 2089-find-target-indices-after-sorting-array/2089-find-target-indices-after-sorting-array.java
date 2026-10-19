class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lessCount = 0;
        int targetFreq = 0;
        
        // Loop ko optimize karne ke liye local variables aur direct checks
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) {
                lessCount++;
            } else if (nums[i] == target) {
                targetFreq++;
            }
        }
        
        // Memory aur speed balance ke liye capacity define karna
        List<Integer> resultList = new ArrayList<>(targetFreq);
        int upperLimit = lessCount + targetFreq;
        
        for (int i = lessCount; i < upperLimit; i++) {
            resultList.add(i);
        }
        
        return resultList;
    }
}