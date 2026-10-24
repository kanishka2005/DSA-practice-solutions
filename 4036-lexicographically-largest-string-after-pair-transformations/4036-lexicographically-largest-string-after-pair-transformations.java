class Solution {
    public String[] largestString(int[] nums) {
        int n = nums.length;
        String[] ans = new String[n];
        // हर एक num के लिए सबसे बड़ी लेक्सिकोग्राफिक स्ट्रिंग बनाएंगे
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            StringBuilder sb = new StringBuilder(); 
            // बड़ी पावर से छोटी पावर की तरफ, Index 26, "zz" -> 2^26,Indices 25 से 0 represents 'z' -'a' -> 2^25-2^0
            for (int k = 26; k >= 0; k--) {
                long weight = (1L << k); // 2^k की वैल्यू कैलकुलेट करना (1L-> 64-bit long)               
                // यदि वर्तमान संख्या 'x' इस वजन (weight) से बड़ी या बराबर है
                if (x >= weight) {
                    long count = x / weight; // यह तय करेगा कि यह करैक्टर या "zz" कितनी बार आएगा
                    x %= weight;             // बची हुई वैल्यू (Remainder) को x में स्टोर करना
                    if (k == 26) {
                        for (long c = 0; c < count; c++) {
                            sb.append("zz");
                        }
                    } else {
                        // k (0 से 25) के लिए corresponding कैरेक्टर ('a' + k) को 'count' बार जोड़ा जाएगा
                        char ch = (char) ('a' + k);
                        for (long c = 0; c < count; c++) {
                            sb.append(ch);
                        }
                    }
                }
            }
            ans[i] = sb.toString(); // बनी हुई स्ट्रिंग को रिजल्ट एरे में डालना
        }
        
        return ans;
    }
}