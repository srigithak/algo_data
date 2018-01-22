package com.srigith.ds.tree;

class LeafAtSameLevel {
    
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
	
	private static class Node{
	    int data;
	    Node left;
	    Node right;
	    
	    public Node(int data){
	        this.data=data;
	    }
	}
}
