package datastructure;

interface A{
    void test();
}
class One implements A{

    public One(){
    System.out.println("This is class One constructor");
    }
    @Override
    public void test() {
        System.out.println("One");
    }
}
class Two extends One{

    public Two(){
        System.out.println("This is class Two Constructor");
    }
    public void test(){
        System.out.println("Two");
    }
}

public class InterfacePractice {

    public static void main(String[] args) {
        One o=new Two();
        o.test();
    }
}
