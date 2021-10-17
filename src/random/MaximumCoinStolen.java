package random;

import java.util.Arrays;

public class MaximumCoinStolen {

    public static void main(String[] args) {
        int[] arr ={1,0,15,9,4,3};
        System.out.println(getMaximumStolenCoin(arr));
    }


    /**
     * Coin cant be picked from consicutive house array
     * shows each house contain coin
     * @param arr
     * @return
     */
    public static Integer getMaximumStolenCoin(int arr[]){
    int value[] = new int[arr.length];
    value[0]=arr[0];
    value[1]=arr[1];
    for(int i=2;i<arr.length;i++){
        value[i]= Math.max(arr[i]+value[i-2],value[i-1]);
    }
    for(Integer i : value){
        System.out.print(i+", ");
    }
        System.out.println();
    return value[arr.length-1];
    }
}