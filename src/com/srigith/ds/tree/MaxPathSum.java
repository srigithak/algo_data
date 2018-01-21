package com.srigith.ds.tree;

public class MaxPathSum {
    public int getMaxPathSum(Node root) {
        if(root == null) {
            return 0;
        }
       
       return getMaxPathSumRec(root);
    }
    
    public int maxPathSum = Integer.MIN_VALUE;
    private int getMaxPathSumRec(Node node){
        if(node==null)
            return 0;
        
        int leftMaxSum = getMaxPathSumRec(node.left);
        int rightMaxSum = getMaxPathSumRec(node.right);
        
        int max = getMax(new int[]{
            leftMaxSum+node.data,
            rightMaxSum+node.data,
            node.data,
            leftMaxSum+node.data+rightMaxSum
        });
        
        if(max > maxPathSum) {
            maxPathSum = max;
        }
        
        return leftMaxSum>rightMaxSum?leftMaxSum+node.data:rightMaxSum+node.data;
    }
    
    private int getMax(int[] inputArr){
        if(inputArr==null || inputArr.length==0)
            return Integer.MIN_VALUE;
        
        int max = inputArr[0];
        for(int i=1;i<inputArr.length;i++) {
            if(inputArr[i]>max)
                max = inputArr[i];
        }

        return max;
    }
    
	public static void main (String[] args) {
		MaxPathSum obj = new MaxPathSum();
		
		Node root = new Node(10);
		root.left = new Node(2);
		root.right = new Node(10);
		root.left.left = new Node(20);
		root.left.right = new Node(1);
		root.right.right = new Node(-25);
		root.right.right.left = new Node(3);
		root.right.right.right = new Node(4);
		
		obj.getMaxPathSum(root);
		System.out.println(obj.maxPathSum);
	}
}

class Node {
    Node left;
    Node right;
    int data;
    
    public Node(int data) {
        this.data=data;
    }
}
