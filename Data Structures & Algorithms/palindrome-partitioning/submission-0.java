class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>ans=new ArrayList<>();
        backtrack(s,0,new ArrayList<>(),ans);
        return ans;
    }
    public void backtrack(String s,int index,List<String>current,List<List<String>>ans){
        if(index==s.length()){
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(ispalindrome(s,index,i)){
                current.add(s.substring(index,i+1));
                backtrack(s,i+1,current,ans);
                current.remove(current.size() - 1);

            }
        }

    }
    public boolean ispalindrome(String s , int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
