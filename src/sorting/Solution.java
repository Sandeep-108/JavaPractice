package sorting;

import datastructure.linkedlistpractice.ListNode;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'maximumToys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY prices
     *  2. INTEGER k
     */

    public static int maximumToys(List<Integer> prices, int k) {
        // Write your code here
        mergeSort(prices,0,prices.size()-1);
        System.out.println(prices);
        return 0;
    }

    public static void mergeSort(List<Integer> list, int s, int e){
        if(s>e)return;
        if(s==e){
            return;
        }
        int mid = s+(e-s)/2;
        mergeSort(list,s,mid);
        mergeSort(list,mid+1,e);
        merge(list,s,mid,e);
    }
    public static void merge(List<Integer> l, int s, int mid, int e){
        int l1 = mid;
        int l2=e;
        while(l2>mid && l1>s){
            if(l.get(l2)>l.get(1)){
                int temp=l.get(l2);
                l.set(l2,l.get(l1));
                l.set(l1,temp);
                l1--;
                l2--;
            }else{
                l2--;
            }
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> list=  Arrays.asList(3,2,1,3,4,2,4,00,3,482,873,-2);
        Result.maximumToys(list,3);
    }
}
