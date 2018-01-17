package com.srigith.ds.tree;

import com.srigith.ds.bean.BinaryTreeNode;

public class SingleValueBTree {

	private int count = 0;
	public int getSingleValueNodeCount(BinaryTreeNode<Integer> root){
		
		if(root==null){
			return 0;
		}
		getSingleValueNodeCount(root,root.getData());	
		
		return count;
	}
	
	public boolean getSingleValueNodeCount(BinaryTreeNode<Integer> node,Integer rootData){
		
		if(node==null){
			return true;
		}
		if(node.getLeftNode()==null && node.getRightNode()==null){
			count++;
			return node.getData().equals(rootData);
		}
		boolean leftChild = getSingleValueNodeCount(node.getLeftNode(),node.getData());
		
		boolean rightChild = getSingleValueNodeCount(node.getRightNode(),node.getData());
		
		if(leftChild && rightChild){
			count++;
		}
		
		Integer leftChildValue = null!=node.getLeftNode()?node.getLeftNode().getData():null;
		Integer rightChildValue = null!=node.getRightNode()?node.getRightNode().getData():null;
		
		return leftChild && rightChild && (leftChildValue==null || leftChildValue.equals(rootData))
				&& (rightChildValue==null || rightChildValue.equals(rootData));
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(5);
		node.setLeftNode(new BinaryTreeNode<Integer>(4));
		node.setRightNode(new BinaryTreeNode<Integer>(5));
		
		node.getLeftNode().setLeftNode(new BinaryTreeNode<Integer>(4));
		node.getLeftNode().setRightNode(new BinaryTreeNode<Integer>(4));

		node.getRightNode().setRightNode(new BinaryTreeNode<Integer>(5));
		
		SingleValueBTree obj=new SingleValueBTree();
		obj.getSingleValueNodeCount(node);
		
		System.out.println(obj.count);
	}
}
