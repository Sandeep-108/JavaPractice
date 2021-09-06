package commons;

public class DistributeBinaryTreeValue {

/**
 *
 *            0
 *          0     2
 *        1  3 1   0
 *   4
 *   //sum == node
 *
 */
public static void main(String[] args) {
    Node root = new Node();
    root.value=0;
    Node val0 = new Node();
    Node val1 = new Node();
    Node val2 = new Node();
    Node val3 = new Node();
    Node val4 = new Node();
    Node val5 = new Node();
    Node val6 = new Node();
    val0.value=0;
    val1.value=1;
    val2.value=1;
    val3.value=3;
    val4.value=2;
    val5.value=1;
    val6.value=0;
    root.left=val0;
    root.right=val4;
    val0.left=val1;
    val0.right=val3;
    val4.left=val5;
    val4.right= val6;
    int[] sum= new int[1];
    getMovedSum(root,sum);
    System.out.println(sum[0]);
}
    public static int getMovedSum(Node root, int[] sum){

        if(root==null) return 0;
        if(root.left==null && root.right==null){
            int value = root.value-1;
            sum[0]+=value<0?value*-1: value;
            return value;
        }
        int leftValue=0;
        int rightValue=0;
        if(root.left!=null){
            leftValue = getMovedSum(root.left,sum);
            System.out.println("leftSum "+leftValue+","+sum[0]);
        }
        if(root.right!=null) {
            rightValue = getMovedSum(root.right,sum);
            System.out.println("rightsum "+rightValue+","+sum[0]);
        }

        //insure current node value is 1
           //            2      -2 = 0
        int LRsum = leftValue+rightValue;
        System.out.println("lrSum "+LRsum+", "+sum[0]+" ,"+root.value);
        int needed= root.value+LRsum-1;
        if(needed==0) return 0;
        sum[0]+=(needed<0? needed*-1:needed);
        System.out.println("needed "+needed+", "+sum[0]);
        return needed;
    }

}

class Node{
    int value;
    Node left;
    Node right;
}