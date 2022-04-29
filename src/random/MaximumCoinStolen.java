package random;

public class MaximumCoinStolen {

    public static void main(String[] args) {
        int[] arr = {1, 0, 15, 9, 4, 3};
        System.out.println(getMaximumStolenCoin(arr));
    }


    /**
     * Coin cant be picked from consicutive house array
     * shows each house contain coin
     *
     * @param arr
     * @return
     */
    public static Integer getMaximumStolenCoin(int arr[]) {
        int n = arr.length;
        int value[] = new int[n];
        value[n - 1] = arr[n - 1];
        value[n - 2] = Math.max(arr[n - 2], arr[n - 1]);
        for (int i = n - 3; i >= 0; i--) {
            value[i] = Math.max(arr[i] + value[i + 2], value[i + 1]);
        }
        for (Integer i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
        for (Integer i : value) {
            System.out.print(i + ", ");
        }
        System.out.println();
        return value[0];
    }
}