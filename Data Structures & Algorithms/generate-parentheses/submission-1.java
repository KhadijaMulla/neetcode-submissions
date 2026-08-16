class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        backtrack(n, 0, 0, new StringBuilder(), ans);

        return ans;
    }

    public void backtrack(int n, int open, int close,
                           StringBuilder current,
                           List<String> ans) {

        if (current.length() == 2 * n) {
            ans.add(current.toString());
            return;
        }

        if (open < n) {
            current.append('(');

            backtrack(n, open + 1, close, current, ans);

            current.deleteCharAt(current.length() - 1);
        }

        if (close < open) {
            current.append(')');

            backtrack(n, open, close + 1, current, ans);

            current.deleteCharAt(current.length() - 1);
        }
    }
}