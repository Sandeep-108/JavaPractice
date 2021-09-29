package random;

import java.util.HashMap;
import java.util.Map;

public class MaximumCoinProblem {

    /**
     * you have an array represent coin you can take coin
     * from one place only if yo not take coin before this
     */
    public static int count=0;
    public static int memcount=0;
    public static void main(String[] args) {
        int []arr = {1,0,0,8,0,9,1,0,4,9,03,5,9,9,0,0,0,1,2,3,8};
        Map<Integer,Integer> mem = new HashMap<>();
        System.out.println(getMaximumCoinMem(arr,0,mem));
        System.out.println(getMaximumCoin(arr,0));
        System.out.println("totalCoutn "+count+", "+memcount+", "+arr.length);
        System.out.println(getMaxCoinDP(arr));
    }


    public static int getMaximumCoin(int []arr, int p){
        count++;
        if(p>=arr.length) {
            return 0;
        }
        if(p==arr.length-1){
            return arr[p];
        }
        int sumWithP = arr[p]+getMaximumCoin(arr,p+2);
        int sumWithoutP = getMaximumCoin(arr,p+1);
        int maxSum = Math.max(sumWithoutP,sumWithP);
        return maxSum;
    }

    public static int getMaximumCoinMem(int []arr, int p,Map<Integer,Integer> mem){
        if(mem.containsKey(p)){
            return mem.get(p);
        }
        memcount++;
        if(p>=arr.length) {
            mem.put(p,0);
            return 0;
        }
        if(p==arr.length-1){
            mem.put(p,arr[p]);
            return arr[p];
        }
        int sumWithP = arr[p]+getMaximumCoinMem(arr,p+2,mem);
        int sumWithoutP = getMaximumCoinMem(arr,p+1,mem);
        int maxSum = Math.max(sumWithoutP,sumWithP);
        mem.put(p,maxSum);
        return maxSum;
    }

    public static int getMaxCoinDP(int[] arr){
        int maxDp[] = new int[arr.length];
        int n= arr.length;
        maxDp[n-1]=arr[n-1];
        maxDp[n-2]= Math.max(arr[n-1],arr[n-2]);
        for(int i=n-3;i>=0;i--){
            maxDp[i]= Math.max(arr[i]+maxDp[i+2],maxDp[i+1]);
        }
        return maxDp[0];
    }
}
