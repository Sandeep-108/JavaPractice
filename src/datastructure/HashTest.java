package datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashTest {

    public static void main(String args[]){
        Map<String ,String> map= new HashMap<>();
        String s="Test";
        String s1="Test";
        String s2= new String ("Test");
//        Integer i=1;
//        Integer i1=new Integer(1);
        map.put(s,"A");
        map.put(s1,"B");
        map.put(s2,"C");
        System.out.println("HashCode of s: "+s.hashCode());//
        System.out.println("HashCode of s1: "+s1.hashCode());//
        System.out.println("HashCode of s2: "+s2.hashCode());//
        System.out.println("HashCode of Test: "+"Test".hashCode());//
        System.out.println(s == s2);
        System.out.println(map.get(s));//C
        System.out.println(map.get(s1));//C
        System.out.println(map.get(s2));//C
        System.out.println(map.get("Test"));//C

        Map<Integer,String> trMap=new TreeMap<>();
        trMap.put(1,"A");
        trMap.put(2,"B");
        trMap.put(3,"C");
        System.out.println(trMap.entrySet());





    }
}
