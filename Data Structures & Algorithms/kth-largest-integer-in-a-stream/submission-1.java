class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        pq=new PriorityQueue<>();
        for(int num:nums){
            pq.add(num);
        
        if(pq.size()>k){
            pq.poll();
        }
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size()>k){
            pq.poll();
        }
        return pq.peek();


        
    }
}
