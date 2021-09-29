package StringTest;

import java.util.HashMap;
import java.util.Map;

/**
 * Find minimum Substring in s1 that contains all character of s2
 */
public class SlidingWindowSubstring {

    public static void main(String[] args) {
        String s1="dbaecbbabdcaafbddcabgba";
        String s2 ="abbcdc";
        System.out.println(getMinimumSubstring(s1,s2));
    }


    public static String getMinimumSubstring(String s1, String  s2){
        String ans="";
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i=0;i<s2.length();i++){
            Character c = s2.charAt(i);
            map2.put(c,map2.getOrDefault(c,0)+1);
        }
        Map<Character,Integer> map1 = new HashMap<>();
        int i=-1;
        int j=-1;
        int matchCount=0;
        int requiredMatchCount=s2.length();
        while (i<s1.length() && j==i){
            //accquire character in window
            boolean loop1=false;
            boolean loop2=false;
            while (i<s1.length()-1 && matchCount<requiredMatchCount){
                i++;
                Character c1 = s1.charAt(i);
                map1.put(c1,map1.getOrDefault(c1,0)+1);
                if(map1.getOrDefault(c1,0)<= map2.getOrDefault(c1,0)){
                    matchCount++;
                }
                loop1=true;
            }
            //collect Answer and release
            while (j<i && matchCount==requiredMatchCount){
                String lans = s1.substring(j+1,i+1);
                if(ans.length()==0|| lans.length()<ans.length()){
                    ans=lans;
                }
                j++;
                char c2 = s1.charAt(j);
                if(map1.get(c2)==1){
                    map1.remove(c2);
                }else {
                    map1.put(c2, map1.get(c2)-1);
                }
                if(map1.getOrDefault(c2,0)< map2.getOrDefault(c2,0)){
                    matchCount--;
                }
                loop2=true;
            }
//            if(!(loop1 ||loop2)) break;
        }
        return ans;
    }
}
