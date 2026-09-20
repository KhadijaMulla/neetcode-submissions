class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> b - a);
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {

        if(left.isEmpty() || num <= left.peek()){
            left.add(num);
        }
        else{
            right.add(num);
        }

        if(left.size() > right.size() + 1){
            right.add(left.poll());
        }

        if(right.size() > left.size()){
            left.add(right.poll());
        }
    }
    
    public double findMedian() {

        if(left.size() == right.size()){
            return (left.peek() + right.peek()) / 2.0;
        }

        return left.peek();
    }
}