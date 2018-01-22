package com.srigith.ds.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MinIterationToAllNodes {
    
    public int getMinIterations(Node root) {
        if(root == null || root.children == null || root.children.isEmpty())
            return 0;
        
        int childSize = root.children.size();
        List<Integer> childMinItr = new ArrayList<Integer>();
        for(int i=0; i<childSize; i++) {
            childMinItr.add(getMinIterations(root.children.get(i)));
        }
        
        Collections.sort(childMinItr,Collections.reverseOrder());
        
        int maxMinItr = childMinItr.get(0);
        for(int i=1; i<childSize; i++) {
            int curMinItr = childMinItr.get(i) + i;
            if(curMinItr>maxMinItr)
                maxMinItr = curMinItr;
        }
        return 1 + maxMinItr;
    }
    
	public static void main (String[] args) {
		Node root = new Node("A");
		Node nodeB = new Node("B");
		Node nodeE = new Node("E");
		Node nodeG = new Node("G");
		
		root.addChildren(nodeB);
		root.addChildren(new Node("C"));
		root.addChildren(new Node("D"));
		root.addChildren(nodeE);
		root.addChildren(new Node("F"));
		root.addChildren(nodeG);
		
		Node nodeH = new Node("H");
		nodeB.addChildren(nodeH);
		nodeB.addChildren(new Node("I"));
		nodeB.addChildren(new Node("J"));
		
		nodeH.addChildren(new Node("N"));
		nodeH.addChildren(new Node("O"));
		
		Node nodeK = new Node("K");
		Node nodeL = new Node("L");
		nodeE.addChildren(nodeK);
		nodeE.addChildren(nodeL);
		
		nodeK.addChildren(new Node("P"));
		nodeL.addChildren(new Node("Q"));
		
		nodeG.addChildren(new Node("M"));
		
		System.out.println(new MinIterationToAllNodes().getMinIterations(root));
	}
	
	private static class Node {
	    List<Node> children; 
	    String data;
	    
	    public Node(String data) {
	        this.data = data;
	        children = null;
	    }
	    
	    public void addChildren(Node child) { 
	        if(child == null)
	            return;
	        
	        if(this.children == null){
	            this.children = new ArrayList<Node>();
	        }
	        this.children.add(child);
	    }
	}
}
