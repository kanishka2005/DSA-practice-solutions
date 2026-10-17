import java.util.HashMap;
import java.util.Map;
class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> countMap = new HashMap<>();
        int left = 0; int maxCount = 0; int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            // Character ki frequency map mein update
            countMap.put(currentChar, countMap.getOrDefault(currentChar, 0) + 1);
            // Window ke andar kisi bhi character ki max frequency track
            maxCount = Math.max(maxCount, countMap.get(currentChar));
            // Agar replacements 'k' se zyada ho jayein, toh window ko left se chhota karein
            while ((right - left + 1) - maxCount > k) {
                char leftChar = s.charAt(left);
                countMap.put(leftChar, countMap.get(leftChar) - 1);
                left++;
            }
            // Maximum valid window length ko update karein
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}