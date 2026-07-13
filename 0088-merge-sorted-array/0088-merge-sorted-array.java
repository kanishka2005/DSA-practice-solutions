class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;// nums1 ke last valid element ka index
        int j = n - 1;// nums2 ke last element ka index
        int k = m + n - 1;// nums1 ka last overall index (final array ka end)

        // Jab tak nums2 ke saare elements place nahi ho jaate
        while (j >= 0) {

            // Agar nums1 mein abhi elements bache hain aur nums1[i] > nums2[j]
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];  // bada element nums1 se aayega
                i--;
            } else {
                // Warna nums2[j] bada (ya nums1 khatam ho gaya)
                nums1[k] = nums2[j];
                j--;
            }

            // Har step ke baad write pointer ko left move karo
            k--;
        }
    }
}