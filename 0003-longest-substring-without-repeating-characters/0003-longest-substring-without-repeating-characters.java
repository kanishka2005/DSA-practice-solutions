class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        int low = 0, res = 0;
        for (int high = 0; high < s.length(); high++) {
            char ch = s.charAt(high);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            // जब तक कोई character repeat हो रहा हो (frequency > 1), window को shrink करो
            while (freq.get(ch) > 1) {
                char lowChar = s.charAt(low);
                freq.put(lowChar, freq.get(lowChar) - 1);
                if (freq.get(lowChar) == 0) {
                    freq.remove(lowChar);
                }
                low++;
            }
            res = Math.max(res, high - low + 1);
        }
        return res;
    }
}