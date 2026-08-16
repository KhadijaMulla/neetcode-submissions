class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        backtrack(nums, new ArrayList<>(), ans);

        return ans;
    }
    public void backtrack(int[]nums,List<Integer>current,List<List<Integer>>ans){
        if(current.size()==nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(current.contains(nums[i])){
                continue;
            }
            current.add(nums[i]);
            backtrack(nums,current,ans);
            current.remove(current.size() - 1);
        }
    }
}
