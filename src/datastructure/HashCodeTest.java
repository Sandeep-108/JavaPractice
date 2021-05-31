package datastructure;
import java.util.HashMap;
import java.util.Map;

class Code{
    int a;
    public Code(int a){
        this.a=a;
    }
    @Override
    public int hashCode() {
        return this.a+56;
    }
    @Override
    public boolean equals(Object obj) {
        Code c=(Code)obj;
        return c.a==this.a;
//        return false;
    }
    @Override
    public String toString(){
        return "this a value is "+super.toString();
    }

}

public class HashCodeTest {

    public static void main(String[] args) {
        Map<Code , String> map =new HashMap<>();
        Code c=new Code(3);
        Code c3=new Code(3);
        Code c1= new Code(1);
        Code c2= new Code(5);
        map.put(c,"A");
        map.put(c1,"B");
        map.put(c2,"C");
        map.put(c3,"E");
        map.put(c,"D");
        System.out.println(map);//10,1,5
        System.out.println(map.get(c3));
        System.out.println(c);
    }
}
