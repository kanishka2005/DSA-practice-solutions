import java.util.*;

public class Solution {
    public static int trap(int height[]) {
        // Guard clause for empty inputs
        //if (height == null || height.length == 0) return 0;
        int n = height.length;

        // Calculate left max boundary
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        
        // Calculate right max boundary
        int rightMax[] = new int[height.length];
        rightMax[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }
        
        // Loop to calculate water
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            int WaterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += WaterLevel - height[i]; 
        }
        
        return trappedWater;
    }
    
    public static void main(String args[]) {
        int height[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution().trap(height));
    }
}