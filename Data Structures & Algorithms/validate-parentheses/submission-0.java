class Solution {
    public boolean isValid(String s) {
        Stack<Character>stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='('||ch=='{'||ch=='['){
                stack.push(ch);
            }
             else {
                if (stack.isEmpty()) {
                    return false;
                }
            char ch1=stack.pop();
            if(ch==')'&&ch1!='('){
                return false;
            }
            if(ch=='}'&&ch1!='{'){
                return false;
            }
            if(ch==']'&&ch1!='['){
                return false;
            }
        
        }
        }
        return stack.isEmpty();
    }
}
