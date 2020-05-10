package datastructure;

public class ChildParent extends Parent {

    ChildParent(){
        System.out.println("Child Constructor calling");
    }
    public static void main(String[] args) {
        ChildParent cp=new ChildParent();
    }
}

class Parent{

    Parent(){
        System.out.println("parent calling");
    }
}