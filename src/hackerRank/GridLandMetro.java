package hackerRank;

import javafx.util.Pair;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class GridLandMetro {

    public static BigInteger gridlandMetro(BigInteger n, BigInteger m, int k, List<List<BigInteger>> track) {
        // Write your code here
        BigInteger totalCount = n.multiply(m);
        Map<BigInteger, List<Pair<BigInteger,BigInteger>>> map = new HashMap<>();
        for(List<BigInteger> trk: track){
            List<Pair<BigInteger,BigInteger>> list = map.getOrDefault(trk.get(0),new ArrayList<>());
            list.add(new Pair(trk.get(1),trk.get(2)));
            map.put(trk.get(0),list);
        }
        Set<BigInteger> keySet = map.keySet();
        for(BigInteger key: keySet){
            List<Pair<BigInteger,BigInteger>> mergeList= mergeOverlapKeySet(map.get(key));
            map.put(key,mergeList);
        }
        BigInteger trackCellCount = BigInteger.ZERO;
        for(BigInteger key : keySet){
            List<Pair<BigInteger,BigInteger>> mergeList = map.get(key);
            for(Pair<BigInteger,BigInteger> p : mergeList){
                BigInteger cell=p.getValue().subtract(p.getKey()).add(BigInteger.ONE);
                trackCellCount =trackCellCount.add(cell);
            }
        }

        return totalCount.subtract(trackCellCount);
    }

    public static List<Pair<BigInteger,BigInteger>> mergeOverlapKeySet(List<Pair<BigInteger,BigInteger>> list){
       List<Pair<BigInteger,BigInteger>> sortedList =  list.stream().sorted(Comparator.comparing(Pair::getKey)).collect(Collectors.toList());
        List<Pair<BigInteger,BigInteger>> mergeList = new ArrayList<>();
        mergeList.add(sortedList.get(0));
        for(int i=1;i<sortedList.size();i++){
            Pair<BigInteger,BigInteger> p1=mergeList.get(mergeList.size()-1);
            Pair<BigInteger, BigInteger> p2 =sortedList.get(i);
            if(isIntersect(p1,p2) ) {
                BigInteger c1= p1.getKey().min(p2.getKey());
                BigInteger c2=p1.getValue().max(p2.getValue());
                Pair<BigInteger, BigInteger> p = new Pair<>(c1,c2);
                mergeList.remove(p1);
                mergeList.add(p);
            } else {
                mergeList.add(sortedList.get(i));
            }
        }
        return mergeList;
    }

    private static boolean isIntersect(Pair<BigInteger, BigInteger> p1, Pair<BigInteger, BigInteger> p2) {

        if(p2.getKey().compareTo(p1.getKey())>=0 && p2.getKey().compareTo(p1.getValue())<=0) return true;
        if(p2.getValue().compareTo(p1.getKey())>=0 && p2.getValue().compareTo(p1.getValue())<=0) return true;

        return false;
    }

    public static void main(String[] args) {
        List<BigInteger> arr1= Arrays.asList(new BigInteger("2"),new BigInteger("2"),new BigInteger("3"));
        List<BigInteger> arr2= Arrays.asList(new BigInteger("2"),new BigInteger("1"),new BigInteger("4"));
        List<BigInteger> arr3= Arrays.asList(new BigInteger("2"),new BigInteger("3"),new BigInteger("4"));
        List<List<BigInteger>> list = Arrays.asList(arr1,arr2,arr3);
        System.out.println(gridlandMetro(new BigInteger("4"),new BigInteger("4"),3,list));

    }
}
