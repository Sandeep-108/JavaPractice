package random;

public class KTransaction {

    public static void main(String[] args) {
        int arr[]= {10, 22, 5, 75, 65, 80};
        System.out.println(maxProfit(10,6,arr));
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
                System.out.println("r: "+r+" c: "+c);
                dp[r][c]= Math.max(max,dp[r][c-1]);
            }
        }
        return dp[k][n];
    }
}

