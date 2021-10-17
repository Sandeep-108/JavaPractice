package StringTest;


public class ResolveStringSpecialRegex {

    public static void main(String[] args) {
        System.out.println(resolveStringRegex("4[4[ar]"));
    }

    
    public static String resolveStringRegex(String s){
        StringBuilder ans= new StringBuilder();
        int openBracket = s.indexOf('[');
        if(openBracket==-1)
            return s;
        //check if any ] before next open
        int num = Integer.parseInt(s.substring(0,openBracket));
        String resolve = resolveStringRegex(s.substring(openBracket+1,s.indexOf(']')));
        while(num>0){
            ans.append(resolve);
            num--;
        }
        return ans.toString();
    }

}
