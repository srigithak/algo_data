package com.srigith.ds.tree;

class MaxSumPathRemoval {
    
    public static Node removeNode(Node root,int k){
        if(root==null){
            return null;
        }
        return removeNode(root,0,k)?root:null;
    }
    
    public static boolean removeNode(Node node, int sum, int k){
        
        if(node==null)
        return sum>=k?true:false;
        
        sum += node.data;
        boolean leftValid = removeNode(node.left,sum,k);
        if(!leftValid){
            node.left = null;
        }
        boolean rightValid = removeNode(node.right,sum,k);
        if(!rightValid){
            node.right = null;
        }
        return leftValid || rightValid;
    }
    
    public static void printTree(Node node){
        if(node==null){
            return;
        }
        printTree(node.left);
        System.out.println(node.data);
        printTree(node.right);
    }
    
    
	public static void main (String[] args) {
		Node root = new Node(1);
		root.left = new Node(5);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(8);
		root.right.right = new Node(9);
		
		root = removeNode(root,10); 
		printTree(root);
	}
	
	private static class Node{
	    int data;
	    Node left;
	    Node right;
	    
	    public Node(int data){
	        this.data=data;
	    }
	}
}
