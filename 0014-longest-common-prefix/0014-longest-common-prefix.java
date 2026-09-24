
class Solution {
    public String longestCommonPrefix(String[] strs) {

        // Assume the first string is the prefix
        String prefix = strs[0];

        // Compare with every other string
        for (int i = 1; i < strs.length; i++) {

            // Reduce prefix until it matches the start
            // of the current string
            while (!strs[i].startsWith(prefix)) {

                prefix = prefix.substring(0, prefix.length() - 1);

                // No common prefix
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}