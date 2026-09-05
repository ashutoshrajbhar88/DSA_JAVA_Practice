class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;

        int maxlength =0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        while(right < s.length()){
            char currentchar = s.charAt(right);

            if(map.containsKey(currentchar)){
                int lastindex = map.get(currentchar);
                int newleft = lastindex+1;
                {
                    if(newleft > left){
                        left = newleft;
                    }
                }
            }
            map.put(currentchar, right);
            int currentwindowsize = right - left +1;

            if(currentwindowsize > maxlength){
                maxlength = currentwindowsize;
            }
            right++;

        }
        return maxlength;
        
    }
}