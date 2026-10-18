class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[256]; //frequency array
        int left = 0;
        int maxCount = 0; // Current window mein max frequency chr.
        int res = 0;
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right); //f[s[high]]++
            // Frequency increment karein
            count[currentChar]++;
            // Max count ko update karein
            maxCount = Math.max(maxCount, count[currentChar]);
            // Agar badalne wale characters 'k' se zyada ho gaye, toh window shrink karo
            while ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) ]--;
                left++;
            }
            // Max length ko update karo
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}