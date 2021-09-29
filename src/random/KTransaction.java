package random;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class KTransaction {

    public static void main(String[] args) {
        int arr[]= {10, 22, 5, 75, 65, 80};
        System.out.println("DP"+maxProfit(2,6,arr));
        System.out.println("WDP"+maxProfitWithoutDP(arr));
        System.out.println("WPDK"+ maxProfitWithoutDPK(arr,2));
    }

    static int maxProfit(int k, int n, int P[]) {
        // code here

        int dp[][]= new int[k+1][n+1];
        for(int r=0;r<=k;r++){
            dp[r][0]=0;
        }
        for(int c=0;c<=n;c++){
            dp[0][c]=0;
        }

        //create DP for all other values
        for(int r=1;r<=k;r++){
            for(int c=1;c<=n;c++){
                int max = Integer.MIN_VALUE;
                for(int m=0;m<c;m++){
                    max = Math.max(max, dp[r-1][m]+P[c-1]-P[m]);
                }
//                System.out.println("r: "+r+" c: "+c);
                dp[r][c]= Math.max(max,dp[r][c-1]);
            }
        }
        return dp[k][n];
    }

    public static int maxProfitWithoutDP(int arr[]){
        int n = arr.length;
        int maxProfit=0;
        int currentPicked =arr[0];
        int position=0;
        int profit = 0;
        for(int i=1; i<arr.length;i++){
            if(profit> (arr[i]-currentPicked)){
                maxProfit+=profit;
                currentPicked =arr[i];
                profit=0;
            }else {
                profit=arr[i]-currentPicked;
            }
        }
        return maxProfit+profit;
    }


    public static int maxProfitWithoutDPK(int arr[], int k){
        int n = arr.length;
        List<Integer> profits = new ArrayList<>();
        int currentPicked =arr[0];
        int position=0;
        int profit = 0;
        for(int i=1; i<arr.length;i++){
            if(profit> (arr[i]-currentPicked)){
                profits.add(profit);
                currentPicked =arr[i];
                profit=0;
            }else {
                profit=arr[i]-currentPicked;
            }
        }
        profits.add(profit);
        Collections.sort(profits);
        int max=0;
        int no = profits.size()-1;
        while(k>0 && no>=0){
            max+=profits.get(no);
            no--;
            k--;
        }
        return max;
    }
}

