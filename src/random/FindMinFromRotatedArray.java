package random;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class FindMinFromRotatedArray implements Serializable {

    transient  int a;
    transient static String s;
    transient final String s1="";

    public static void main(String[] args) {


        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9,0);
        int n = findMin(integerList, 0, integerList.size()-1);
        System.out.println(n);
    }

    public static int findMin(List<Integer> list, int start, int end) {
        if (start > end) {
            return list.get(0);
        }
        for (int i=start; i<=end; i++)
            System.out.print(list.get(i)+", ");
        System.out.println();
        if (start == end) {
            return list.get(start);
        }
        //Check mid+1 and mid-1 whith mid
        int mid = (start+end)/2;
        // 5,4
        if(list.get(mid)> list.get(mid+1)){
            return list.get(mid+1);
        }
        //if mid itself min element 4, 5
        if(mid>0)
        if(list.get(mid-1) > list.get(mid)){
            return  list.get(mid);
        }

        if(list.get(end)>list.get(mid)){
            return findMin(list,start,mid);
        }else {
            return findMin(list, mid+1,end);
        }
    }
}

