package random;

import java.util.*;

public class StreamMedian {

    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(1,-2,3,-4,-3,-1);
        System.out.println(getMedians(data));
    }

    public static List<Double> getMedians(List<Integer> data){
        List<Double> medianList = new ArrayList<>();
        //minimum of bigger element
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        //maximum of lower element
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<data.size();i++){
            minHeap.add(data.get(i));
            maxHeap.add(minHeap.poll());
            balance(minHeap,maxHeap);
            medianList.add(median(minHeap,maxHeap, i+1));

        }
        return medianList;
    }

    private static Double median(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int i) {
        if(i%2!=0){
            return minHeap.peek()*1.0;
        }
        return maxHeap.peek()/2.0 + minHeap.peek()/2.0;
    }

    private static void balance(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if(maxHeap.size()>minHeap.size()){
            minHeap.add(maxHeap.poll());
        }
        System.out.println(maxHeap+ ","+ minHeap);
    }
}
