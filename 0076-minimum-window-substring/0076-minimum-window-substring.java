public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        int[] freq = new int[128];
        for (char c : t.toCharArray()) {
            freq[c]++;
        }
        int left = 0, right = 0;
        int required = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            // If character in s is part of t, decrease required
            if (freq[r] > 0) {
                required--;
            }
            freq[r]--;
            right++;
            // When we have all characters
            while (required == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                // Left pointer ko aage badhayein aur window shrink karein
                char lChar = s.charAt(left);
                freq[lChar]++;
                if (freq[lChar] > 0) {
                    required++;
                }
                left++;
            }
        }
        // Agar koi valid window nahi mili toh empty string return karein, warna minimum substring
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}