class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0, res = 0;
        Map<Integer, Integer> freq = new HashMap<>(4,0.75f);
        for (int right = 0; right < n; right++) {
            freq.put(fruits[right], freq.getOrDefault(fruits[right], 0) + 1);
            // shrink window if more than 2 fruit types
            while (freq.size() > 2) {
                int leftFruit = fruits[left];
                freq.put(leftFruit, freq.get(leftFruit) - 1);
                if (freq.get(leftFruit) == 0)
                    freq.remove(leftFruit);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}    