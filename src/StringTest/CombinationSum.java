package StringTest;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int arr[] ={2,3,6,7};
        int target= 14;
        List<List<Integer>> result = new ArrayList<>();
        getCombinationSum(arr,0,target,new ArrayList<>(),result);
        for(List<Integer> res: result){
            System.out.println(res);
        }
    }


    public static void getCombinationSum(int[] arr, int start, int target, List<Integer> list,
                                         List<List<Integer>> result){
        if(target<0)
            return;
        if(target==0){
            result.add(new ArrayList<>(list));
        }
        for(int i=start; i<arr.length;i++){
            list.add(arr[i]);
            getCombinationSum(arr,i,target-arr[i],list,result);
            list.remove(list.size()-1);
        }
    }
}
