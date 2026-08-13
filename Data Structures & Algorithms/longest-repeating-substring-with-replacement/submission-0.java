class Solution {
    public int characterReplacement(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxFreq = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {

           char ch=s.charAt(right);
           map.put(ch,map.getOrDefault(ch,0)+1);
           maxFreq=Math.max(maxFreq,map.get(ch));
           int windowsize=right-left+1;
           int replacement=windowsize-maxFreq;

           while(replacement>k){
            char leftchar=s.charAt(left);
            map.put(leftchar,map.get(leftchar)-1);
            left++;
           
           
            windowsize = right - left + 1;
                replacement = windowsize - maxFreq;
           }
                max=Math.max(max,right-left+1);
        }
                return max;
    }
}