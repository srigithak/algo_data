package com.srigith.ds.bean;

public class BinaryTreeNode<T> {

	private T data;
	private BinaryTreeNode<T> leftNode;
	private BinaryTreeNode<T> rightNode;
	
	public BinaryTreeNode(T data){
		this.data = data;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BinaryTreeNode<T> getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(BinaryTreeNode<T> leftNode) {
		this.leftNode = leftNode;
	}
	public BinaryTreeNode<T> getRightNode() {
		return rightNode;
	}
	public void setRightNode(BinaryTreeNode<T> rightNode) {
		this.rightNode = rightNode;
	}
	
}
/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    
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
}
class Node{
    int data;
    Node left;
    Node right;
    
    public Node(int data){
        this.data=data;
    }
}

/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    
    static int maxheight=-1;
    public static boolean isAtSameLevel(Node root){
        if(root==null){
            return true;
        }
        
        return isAtSameLevel(root,0);
    }
    
    public static boolean isAtSameLevel(Node root,int level){
    
        if(root==null){
            return true;
        }
        
        if(root.left==null && root.right==null){
            if(maxheight!=-1){
                return maxheight==level;
            }else{
                maxheight=level;
                return true;
            }
        }
        
        return isAtSameLevel(root.left,level+1) && isAtSameLevel(root.right,level+1);
            
    }
    
	public static void main (String[] args) {
		Node root = new Node(1);
		root.left = new Node(5);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		//root.right.left = new Node(8);
		//root.right.right = new Node(9);
		
		System.out.println(isAtSameLevel(root));
	}
}
class Node{
    int data;
    Node left;
    Node right;
    
    public Node(int data){
        this.data=data;
    }
}
