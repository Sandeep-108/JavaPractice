package random;

import java.util.Arrays;
import java.util.List;

public class MaxSubArraySum {


    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,4,10,-3,0,2);//

        int startIndex=0; //0, 2
        int endIndex =0; //0 2 ,4
        int auxEndIndex =0; //4
        Integer max = integerList.get(0);  //1 4,
        Integer sum = integerList.get(0);;// 0 3
        for( int i=1; i<integerList.size();i++) {
            if(sum >max){
                max =sum;
                endIndex =i-1;
                startIndex = auxEndIndex;
            }
            sum = sum + integerList.get(i);//-1 ,4 , -1, 3,5
            if (sum < 0) {
                sum = 0;//0
                auxEndIndex =i+1; //2, 4
            }
        }
       if( sum >max){
            max = sum; //5
            endIndex = integerList.size()-1; //6
           startIndex = auxEndIndex; //4
       }
        System.out.println(max+"startIndex: "+startIndex+"endIndex: "+endIndex);
    }
}
