class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        backtrack(nums,target,0,new ArrayList<>(),ans);
        return ans;
    }
    public void backtrack(int[]nums,int target,int index,List<Integer>current,List<List<Integer>>ans){
        if(target==0){
            ans.add(new ArrayList<>(current));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=index;i<nums.length;i++){
            current.add(nums[i]);
            backtrack(nums,target-nums[i],i,current,ans);
            current.remove(current.size()-1);
        }
    }
}
