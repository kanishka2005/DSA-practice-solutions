class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lessCount = 0;
        int targetFrequency = 0;
        for(int val : nums) {
            if(val < target){
                lessCount++;
            }else if(val == target){
                targetFrequency++;
            }
        }
        List<Integer> resultList = new ArrayList(targetFrequency);
        int limit = lessCount + targetFrequency;
        for (int idx = lessCount; idx < limit; idx++){
            resultList.add(idx);
        }
        return resultList;
    }
}