import java.util.HashMap;
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        // value -> index store karega
        Map<Integer, Integer> map = new HashMap<>();
        // poore array par loop
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{ map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
    // sample run ke liye main function
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] ans = twoSum(nums, target);
        System.out.println("Indices: " + ans[0] + ", " + ans[1]);
        System.out.println("Values: " + nums[ans[0]] + ", " + nums[ans[1]]);
    }
}