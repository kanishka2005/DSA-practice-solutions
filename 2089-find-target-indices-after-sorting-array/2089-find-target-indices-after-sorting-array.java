class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n= nums.length;
        List<Integer> ans= new ArrayList();
        int c1= 0;
        int c2= 0;

        for(int i=0; i<n; i++){
            if(nums[i]<target){
                c1++;
            }else if(nums[i]==target){
                c2++;
            }
        }

        for (int i = c1; i < c1 + c2; i++) {
            ans.add(i);
        }
        return ans;
    }
}