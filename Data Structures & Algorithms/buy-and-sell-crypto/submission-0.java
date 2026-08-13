class Solution {
    public int maxProfit(int[] prices) {
        
        int min=Integer.MAX_VALUE;
        int maxprofit=0;
        for(int i=0;i<prices.length;i++){
            int current=prices[i];
            if(current<min){
                min=current;
            }
            else{
               int  currprofit=current-min;
               maxprofit=Math.max(maxprofit,currprofit);
            }
        }
        return maxprofit;
    }
}
