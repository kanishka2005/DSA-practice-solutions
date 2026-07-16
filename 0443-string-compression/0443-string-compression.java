public class Solution {
    public int compress(char[] chars) {
        // Base case
        if (chars == null || chars.length == 0) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        int count = 1;  // Current character ka count

        // Array mein traverse karna
        for (int i = 1; i < chars.length; i++) {
            char curr = chars[i];
            char prev = chars[i - 1];

            if (curr == prev) {
                // Agar same character hai, toh count badhao
                count++;
            } else {
                // Alag character aane par, purana character append karo
                sb.append(prev);
                // Agar count 1 se zyada hai, tabhi count append karo
                if (count > 1) {
                    sb.append(count);
                }
                // Naye character ke liye count reset karo
                count = 1;
            }
        }

        // Last group of characters ko handle karna
        char lastChar = chars[chars.length - 1];
        sb.append(lastChar);
        if (count > 1) {
            sb.append(count);
        }

        // LeetCode ki requirement: Original array ko modify karna hai
        String compressedStr = sb.toString();
        for (int i = 0; i < compressedStr.length(); i++) {
            chars[i] = compressedStr.charAt(i);
        }

        // Return the new length
        return compressedStr.length();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        char[] s1 = {'a', 'a', 'a', 'b', 'b', 'c', 'c', 'd', 'e', 'e'};
        char[] s2 = {'a', 'b', 'c'};
        char[] s3 = {'a', 'a', 'a', 'a', 'a'};

        System.out.println(sol.compress(s1)); // Output: 9 (a3b2c2de2)
        System.out.println(sol.compress(s2)); // Output: 3 (abc)
        System.out.println(sol.compress(s3)); // Output: 2 (a5)
    }
}