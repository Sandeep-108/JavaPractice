package datastructure;

import java.util.ArrayList;
import java.util.List;

class LinkedList<T> {
    T data;
    LinkedList next;
//    LinkedList head;

    public LinkedList() {
    }
    public LinkedList(T data){
       this.data=data;
//       head=this;
    }

//For Insertion in Linked List
    public LinkedList insert(T data){
//        if(head ==null){
//            head=new LinkedList(data);
        if(this.data==null){
            this.data=data;
        }else{
            LinkedList currentNode=this;
            while(currentNode.next!=null){
                currentNode=currentNode.next;
            }
            currentNode.next=new LinkedList(data);
        }
        return this;
    }
    public LinkedList insert(int position,T data) {
        if(position<0){
            throw new RuntimeException("Position must be positive number");
        }
        if(position==0){
            LinkedList newFirstNode=new LinkedList(this.data);
            this.data=data;
            newFirstNode.next=this.next;
            this.next=newFirstNode;
        }
        LinkedList currentNode=this;
        while(position!=0 && currentNode!=null){
            currentNode=currentNode.next;
            position--;
        }
        if(position==0){
            currentNode=new LinkedList(data);
        }else{
            throw new RuntimeException("Invalid Position");
        }
        return this;
    }
    public T get(int position){
        if(this==null){
            throw new RuntimeException("Invalid position");
        }
        LinkedList currentNode=this;
        while(position!=0 && currentNode!=null){
            currentNode=currentNode.next;
            position--;
        }
        if(position!=0){
            throw new RuntimeException("Invalid position");
        }
        return (T)currentNode.data;
    }
    @Override
    public String toString(){
       StringBuffer sb=new StringBuffer();
       sb.append("Linked List[");
       LinkedList curr=this;
       while(curr!=null){
           sb.append(curr.data+", ");
           curr=curr.next;
       }
       sb.append("]");
       return sb.toString();
    }
}

public class LinkedListCreation{

    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<>();
        list.insert(10);
        list.insert(20);
        list.insert(0,30);
        list.insert(0,35);
        System.out.println(list);
    }

}
