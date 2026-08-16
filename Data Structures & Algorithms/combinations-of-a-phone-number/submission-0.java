class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(digits, 0, "", map, ans);

        return ans;
    }

    public void backtrack(String digits, int index,
                           String current, String[] map,
                           List<String> ans) {

        if (index == digits.length()) {
            ans.add(current);
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {

            current += letters.charAt(i);

            backtrack(digits, index + 1, current, map, ans);

            current = current.substring(0, current.length() - 1);
        }
    }
}