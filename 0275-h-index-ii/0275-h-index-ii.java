class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int papers = n - mid;
            
            if (citations[mid] == papers) {
                return papers;
            } else if (citations[mid] < papers) {
                // Not enough citations for this many papers; search the right half
                left = mid + 1;
            } else {
                // Valid candidate, but check the left half to see if we can include more papers
                right = mid - 1;
            }
        }
        
        // 'left' points to the first valid index where citations[left] >= n - left
        return n - left;
    }
}