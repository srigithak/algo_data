package com.srigith.ds.tree;

public class MaxPathSum {
    public int getMaxPathSum(BinaryNode root) {
        if(root == null) {
            return 0;
        }
       
       return getMaxPathSumRec(root);
    }
    
    public int maxPathSum = Integer.MIN_VALUE;
    private int getMaxPathSumRec(BinaryNode node){
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
		
		BinaryNode root = new BinaryNode(10);
		root.left = new BinaryNode(2);
		root.right = new BinaryNode(10);
		root.left.left = new BinaryNode(20);
		root.left.right = new BinaryNode(1);
		root.right.right = new BinaryNode(-25);
		root.right.right.left = new BinaryNode(3);
		root.right.right.right = new BinaryNode(4);
		
		obj.getMaxPathSum(root);
		System.out.println(obj.maxPathSum);
	}
}

class BinaryNode {
	BinaryNode left;
	BinaryNode right;
    int data;
    
    public BinaryNode(int data) {
        this.data=data;
    }
}
