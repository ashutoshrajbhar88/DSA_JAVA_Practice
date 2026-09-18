class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }
        int[] freq = new int[26];
        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }
        int left = 0;
        int right = 0;
        int needed = s1.length();

        while (right < s2.length()) {
            int index = s2.charAt(right) - 'a';
             if (freq[index] > 0) {
                needed--;
            }
             freq[index]--;
            right++;
            if (right - left > s1.length()) {
                int leftIndex = s2.charAt(left) - 'a';
                if (freq[leftIndex] >= 0) {
                    needed++;
                }
                freq[leftIndex]++;
                left++;
            }
            if (needed == 0) {
                return true;
            }
        }
        return false;
    }
}