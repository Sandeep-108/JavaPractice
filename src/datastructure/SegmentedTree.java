package datastructure;

import java.util.Map;

public class SegmentedTree {

    public static void main(String[] args) {
        int ar[] = new int[]{1,4,-2,3};
        //maximum possible size of tree is 4n+1
        int tree[] = new int[4*ar.length+1];
        buildSegmentedTree(tree, ar,1,0,ar.length-1);
        for(int i :tree) System.out.print(i+", ");
        System.out.println();
        rangeUpdate(tree,1,0,ar.length-1,3,3,8);
        for(int i :tree) System.out.print(i+", ");
        System.out.println();
        System.out.println(queryExecute(tree,1,0,ar.length-1,1,1));
    }

    private static void buildSegmentedTree(int[] tree, int[] ar, int index, int s, int e) {
        //Base case when start is greater than e
        if(s>e){
            return;
        }
        ///Base case when start and end are same means we are at leave node
        if(s==e){
            tree[index] = ar[s];
            return;
        }
        //recursive call for left and right
        int mid = (s+e)/2;
        //build  left sub tree
        buildSegmentedTree(tree,ar,2*index,s,mid);
        //Build right sub tree
        buildSegmentedTree(tree,ar,2*index+1,mid+1,e);
        //store minimum of left and right at current position
        int left = tree[2*index];
        int right = tree[2*index+1];
        tree[index] = Math.min(left,right);
        return;
    }

    public static int queryExecute(int[] tree,int index, int s, int e, int qs, int qe) {
        ///1. Base case No Overlap
        if(s>qe || e<qs) {
            return Integer.MAX_VALUE;
        }
        //2. Complete ovelap
        if(qs<=s && qe>=e) {
            return tree[index];
        }

        //3. partial overlap
        //a call left subtree
        int mid = (s+e)/2;
        int left = queryExecute(tree,2*index,s,mid,qs,qe);
        //call right subtree
        int right = queryExecute(tree,2*index+1,mid+1,e,qs,qe);
        return Math.min(left,right);
    }

    public static void nodeUpdate(int[] tree, int index, int s,int e, int n, int v){
        //1. No Overlap
        if(s>n || e<n){
            return;
        }
        //2.if its leaf update
        if(s==e) {
            tree[index] = v;
            return;
        }
        //3.partial overlap
        int mid = (s+e)/2;
        //call left subtree
         nodeUpdate(tree,2*index,s,mid,n,v);
         //call right subtree
        nodeUpdate(tree,2*index+1,mid+1,e,n,v);
        tree[index] = Math.min(tree[2*index],tree[2*index+1]);
        return;
    }

    public static void rangeUpdate(int[] tree, int index, int s,int e, int qs, int qe, int inc){
        //1. No Overlap
        if(s>qe || e<qs){
            return;
        }
        //2.if its leaf update
        if(s==e) {
            tree[index] +=inc;
            return;
        }
        //3.partial overlap
        int mid = (s+e)/2;
        //call left subtree
        rangeUpdate(tree,2*index,s,mid,qs,qe,inc);
        //call right subtree
        rangeUpdate(tree,2*index+1,mid+1,e,qs,qe,inc);
        tree[index] = Math.min(tree[2*index],tree[2*index+1]);
        return;
    }
}
