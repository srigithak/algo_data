package com.srigith.ds.tree;

public class BinaryToDLL {
	
	Node head = null;
	Node prev = null;
	
	
	public void convertToDLLUtil(Node root) {
	    if(root == null){
	       return;
	   }
	   convertToDLL(root);
	   head.left = prev;
       prev.right = head;
	}
	
	public void convertToDLL(Node node) {
  
	   if(node == null){
	       return;
	   }	   
	   convertToDLL(node.left);
	   
	   if(head==null){
	      head = node;
	   }else{
	       node.left = prev;
	       prev.right = node;
	   }
	   prev = node;
	   
	   convertToDLL(node.right);
	}
	
	public void display(Node head)
    {
        System.out.println("Circular Linked List is :");
        Node itr = head;
        do
        {
            System.out.print(itr.data+ " " );
            itr = itr.right;
        }
        while (itr != head);
        System.out.println();
    }
	
	public static void main (String[] args) {
	    
		BinaryToDLL obj = new BinaryToDLL();
		 // Build the tree
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);
 
        // head refers to the head of the Link List
        obj.convertToDLLUtil(root);
 
        // Display the Circular LinkedList
        obj.display(obj.head);
	}
	
	private static class Node {
	    Node left;
	    Node right;
	    int data;
	    
	    public Node(int data){
	        this.data = data;
	    }
	}
}
