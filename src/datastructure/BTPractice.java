package datastructure;

import java.util.Stack;

class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
class Service{

    //Inorder Traversal
    public void inOrderTraversal(Node root){
        if(root==null){
            return ;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data+" ,");
        inOrderTraversal(root.right);
    }

    public void inOrderTraversalWithoutRecursion(Node root){
        Stack<Node> stack= new Stack<>();
        Node curr= root;
        while (curr !=null || stack.size()>0){
            while( curr !=null){
                stack.push(curr);
                curr= curr.left;
            }
            curr =stack.pop();
            System.out.print(curr.data+", ");
            curr=curr.right;
        }
    }
    public void postOrderTraversal(Node root){
        if(root==null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+", ");
    }
    public void postOrderTraversalWithoutRecursion(Node root){
        Stack<Node> st= new Stack<>();
        Node curr = root;
        while (true){
            while (curr !=null){
                st.push(curr);
                st.push(curr);
                curr =curr.left;
            }
            if(st.empty())return;
            curr =st.pop();
            if(!st.empty() && st.peek() == curr) curr = curr.right;
            else {
            System.out.print(curr.data+", ");
            curr=null;
            }

        }
    }
}
public class BTPractice {
    public static void main(String[] args) {

        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        Node n6=new Node(6);
        n4.right=n5;
        n5.right=n6;
        n4.left=n2;
        n2.right=n3;
        n2.left=n1;

        new Service().inOrderTraversal(n4);
        System.out.println();
        new Service().inOrderTraversalWithoutRecursion(n4);
        System.out.println();
        new Service().postOrderTraversal(n4);
        System.out.println();
        new Service().postOrderTraversalWithoutRecursion(n4);
    }
}
