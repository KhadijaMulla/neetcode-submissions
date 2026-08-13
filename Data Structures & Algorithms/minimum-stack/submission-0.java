class MinStack {
    Stack<int[]> obj;

    public MinStack() {
        obj = new Stack<>();
        
    }
    
    public void push(int value) {
       if(obj.isEmpty()){
        obj.push(new int[]{value,value});
       }
       else{
        int currentmin=Math.min(value,obj.peek()[1]);
        obj.push(new int[]{value,currentmin});
       }
        
    }
    
    public void pop() {
        obj.pop();
       
        
    }
    
    public int top() {
        return obj.peek()[0];
       
        
    }
    
    public int getMin() {
        return obj.peek()[1];
        
        
    }
}