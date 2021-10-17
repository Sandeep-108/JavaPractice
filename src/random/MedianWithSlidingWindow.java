package random;

import java.util.*;

public class MedianWithSlidingWindow {

    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(1,-2,3,-4,-2,-1);
        System.out.println(new MedianWithSlidingWindow().getMedianList(data,3));
    }


    public List<Double> getMedianList(List<Integer> data,int w){
        List<Double> medianList = new ArrayList<>(data.size()-w);
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        //check edge cases
        if(data.size()<=w) return medianList;
        //initialize Window
        for(int i=0;i<data.size();i++){
            if(i<w){
                addInHeap(minHeap,maxHeap,data.get(i));
                continue;
            }
            medianList.add(getMedian(maxHeap,minHeap,w));
            removeHeap(minHeap,maxHeap,data.get(i-w));
            addInHeap(minHeap,maxHeap,data.get(i));

        }
        medianList.add(getMedian(maxHeap,minHeap,w));
        return medianList;
    }

    private void removeHeap(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, Integer integer) {
        minHeap.remove(integer);
        maxHeap.remove(integer);
    }

    private void addInHeap(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, Integer integer) {
        minHeap.add(integer);
        maxHeap.add(minHeap.poll());
        balance(minHeap,maxHeap);
    }

    private Double getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int w) {
        if(w%2!=0){
            return minHeap.peek()*1.0;
        }
        return maxHeap.peek()/2.0 + minHeap.peek()/2.0;
    }

    private void balance(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        while(maxHeap.size()>minHeap.size()){
            minHeap.add(maxHeap.poll());
        }
    }
}
