package hackerRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HackerLandRadioTransmission {


    public static void main(String[] args) {
        System.out.println(hackerlandRadioTransmitters(Arrays.asList(7 ,2 ,4 ,6 ,5 ,9 ,12 ,11), 2));
    }

    public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
        // Write your code here
        Collections.sort(x);
        int trnsmt = 0;
        int i = 0;
        int n = x.size();
        while (i < n) {
            trnsmt++;
            int transmtLoc= x.get(i)+k;
            //find transmtLoc position
            while(i<n && x.get(i)<=transmtLoc){
                i++;
            }
            System.out.println(x.get(i-1));
            //now i-1 is position where txs placed
            //now find range of current tx
            int rangeLoc= x.get(i-1)+k;
            while(i<n && x.get(i)<=rangeLoc){
                i++;
            }

        }

        return trnsmt;
    }
}
