class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer>list=new ArrayList<>(map.keySet());
         list.sort((a, b) -> map.get(b) - map.get(a));

         int []ans=new int[k];
         for(int i=0;i<k;i++){
            ans[i]=list.get(i);
         }
         return ans;
    }
}
