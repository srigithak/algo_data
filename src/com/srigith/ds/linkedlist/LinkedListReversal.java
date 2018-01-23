package com.srigith.ds.linkedlist;

class LinkedListReversal {
    Node head = null;
    public void reverseLinkedList() {
        if(head==null || head.next==null)
            return;
        Node curNode = head;
        Node newHead = null;
        while(null!=curNode){
            Node next = curNode.next;
            
            if(null!=newHead){
                newHead.prev = curNode;
            }
            curNode.next = newHead;
            
            newHead = curNode;
            curNode = next;
        }
        
        head = newHead;
    }
    
    public void push(Node node){
        if(head == null){
            head = node;
        } else {
            node.next = head;
            node.prev = null;
            head.prev = node;
            head = node;
        }
    }
    
    public void printList(){
        Node curNode = head;
        while(null!=curNode){
            System.out.println(curNode.data);
            curNode = curNode.next;
        }
    }
    
	public static void main (String[] args) {
		LinkedListReversal list = new LinkedListReversal();
		list.push(new Node(10));
		list.push(new Node(8));
		list.push(new Node(4));
		list.push(new Node(2));
		
		list.printList();
		list.reverseLinkedList();
		System.out.println("----Reversal---");
		list.printList();
	}
	
	private static class Node{
	    int data;
	    Node next=null;
	    Node prev=null;
	    
	    public Node(int data){
	        this.data = data;
	    }
	} 
}
