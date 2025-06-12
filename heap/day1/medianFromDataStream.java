/*
Brute: after adding num , sort the arraylist
T.c -> o(nlogn)
S -> o(n)
 */

/*
optimal: use 2 heaps left max and right min
T.C -> log(n)
S -> o(n)
 */

class MedianFinder {

    PriorityQueue<Integer> left_max_heap;
    PriorityQueue<Integer> right_min_heap;
    
    public MedianFinder() {
        left_max_heap = new PriorityQueue<>(Collections.reverseOrder());
        right_min_heap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left_max_heap.isEmpty() || num < left_max_heap.peek()){
            left_max_heap.add(num);
        }else{
            right_min_heap.add(num);
        }

        if(right_min_heap.size() > left_max_heap.size()){
            left_max_heap.add(right_min_heap.poll());
        }else if(left_max_heap.size() > right_min_heap.size() + 1){
            right_min_heap.add(left_max_heap.poll());
        }

    }
    
    public double findMedian() {
        if((right_min_heap.size() + left_max_heap.size()) % 2 == 0){
            return (double)(right_min_heap.peek() + left_max_heap.peek()) / 2;
        }

        return left_max_heap.peek();
    }
}