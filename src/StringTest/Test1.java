package StringTest;

public class Test1 {
    public static void main(String[] args) {
        String a="A";
        String b="B";
        String c=a;
        System.out.println(a.hashCode());
        System.out.println(c.hashCode());
        a="Ab";
        System.out.println(a.hashCode());
        System.out.println(c.hashCode());
    }


}
