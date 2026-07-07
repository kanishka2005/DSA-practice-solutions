public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            // Avoid potential overflow compared to (left + right) / 2
            int mid = left + (right - left) / 2;
            
            // 1. Found the target!
            if (nums[mid] == target) {
                return mid;
            }
            
            // 2. Check if the Left side is normally sorted
            if (nums[left] <= nums[mid]) {
                // Is the target sitting comfortably inside this sorted left half?
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Yes, look left
                } else {
                    left = mid + 1;  // No, look right
                }
            } 
            // 3. Otherwise, the Right side MUST be normally sorted
            else {
                // Is the target sitting comfortably inside this sorted right half?
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;  // Yes, look right
                } else {
                    right = mid - 1; // No, look left
                }
            }
        }
        
        // Target doesn't exist in the array
        return -1;
    }
}