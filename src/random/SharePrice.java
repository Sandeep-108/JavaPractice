package random;

public class SharePrice {

    /**
     *  The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days. For example, if the given array is
     {100, 180, 260, 310, 40, 535, 695}, find the max profit

     Reliance
     Arr[] = {100, 180, 260, 310, 40, 535, 695}
     maxProfit : 695 - 40 = 655
     */

    public static Integer maxProfit(int[] priceList){
        if(priceList==null || priceList.length<=1){
            return 0;
        }
        int min = priceList[0];
        int profit = 0;
        for(int i=0; i< priceList.length;i++){
            if(min>priceList[i]){
                min=priceList[i];
            }
            if((priceList[i]-min)>profit){
                profit= priceList[i]-min;
            }

        }
        return profit;
    }

    public static void main(String[] args) {
        int arr[] = {100, 180, 260, 310, 695, 535, 40};
        System.out.println(maxProfit(arr));
    }

}
