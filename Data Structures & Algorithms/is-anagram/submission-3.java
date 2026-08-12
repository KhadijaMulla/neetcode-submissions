class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> count1 = new HashMap<>();
        HashMap<Character, Integer> count2 = new HashMap<>();
        for (char ch : s.toCharArray()) {
            count1.put(ch, count1.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            count2.put(ch, count2.getOrDefault(ch, 0) + 1);
        }
        return count1.equals(count2);
    }
}