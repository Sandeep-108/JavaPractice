package random;

public class CountPalindromeSubstring {

    public static void main(String[] args) {
        String s = "abccbc";
        System.out.println(getPalindromeSubstringCount(s));
    }
    public static int getPalindromeSubstringCount(String s){
        int n=s.length();
        //create DP
        boolean dp[][]= new boolean[n][n];
        //traverse matrix using gap
        int count=0;
        for(int g=0;g<n;g++){
            //for each gap start with row 0 and end in last column
            for(int i=0,j=g;j<n;j++,i++){
               //length 1 string always palindrome
                if(g==0){
                    dp[i][j]=true;
                }
                //check for length 2
                else if(g==1){
                    dp[i][j]= s.charAt(i)==s.charAt(j);
                }else{
                    dp[i][j]=(s.charAt(i)==s.charAt(j))&&dp[i+1][j-1];
                }
                if(dp[i][j]) count++;
            }
        }
        return count;
    }
}
