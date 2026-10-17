class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0, res = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int right = 0; right < n; right++) {
            int fruit = fruits[right];
            freq.put(fruit, freq.getOrDefault(fruit, 0) + 1);
            // shrink window if more than 2 fruit types
            while (freq.size() > 2) {
                int leftFruit = fruits[left];
                int count = freq.get(leftFruit) - 1;
                if (count == 0){
                    freq.remove(leftFruit);
                }else{
                    freq.put(leftFruit, count);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}    