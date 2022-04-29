package hackerRank;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Result {

    /*
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */

    public static int activityNotifications(List<Integer> expenditure, int d) {
        // Write your code here
        int notificationCount = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        if(expenditure.size()<d) return 0;
        for(int i=0; i<expenditure.size();i++){
            if(i<d){
                addInHeap(minHeap,maxHeap,expenditure.get(i));
                continue;
            }
            double median = getMedian(minHeap, maxHeap,d);
            if(median*2<=expenditure.get(i)){
                notificationCount++;
            }
            removeHeap(minHeap,maxHeap,expenditure.get(i-d));
            addInHeap(minHeap,maxHeap,expenditure.get(i));
        }

        return notificationCount;
    }

    public static void addInHeap(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap,int value){
                minHeap.add(value);
                maxHeap.add(minHeap.poll());
        if(minHeap.size()<maxHeap.size()){
            minHeap.add(maxHeap.poll());
        }
    }

    public static void removeHeap(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap,int value){
        if(!maxHeap.remove(value)){
            minHeap.remove(value);
        }
        if(minHeap.size()<maxHeap.size()){
            minHeap.add(maxHeap.poll());
        }
    }
    public static Double getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap,int d) {
        if (d % 2 != 0) {
            return minHeap.peek() * 1.0;
        }
        return (minHeap.peek() * 0.5) + (maxHeap.peek() * 0.5);
    }


}