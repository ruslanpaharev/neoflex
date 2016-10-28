package binarytree.node;

import binarytree.container.Containerable;

public class Node extends AbstractSortedNode{
	
	public Node(int value) {
		this.value = value;
	}
	
	public Node(String name, int value) {
		this(value);
		this.name = name;
	}
		
	public void addLeftChild(int value){
		leftChild = new Node(this.name + "0", value);
		leftChild.parent = this;
	}
	
	public void addRightChild(int value){
		rightChild = new Node(this.name + "1", value);
		rightChild.parent = this;
	}	
		
	@Override
	protected void moveToChild(Containerable func){			
		if(leftChild != null) leftChild.moveToChild(func);
		
		func.function(this);
										
		if(rightChild != null) rightChild.moveToChild(func);
	}
	
	@Override
	protected void insert(Node node){
		if (node.value < value){
			if (leftChild != null) leftChild.insert(node);
			else{ 
				leftChild = node;
				leftChild.parent = this;
				leftChild.name = (this.name + "0");
			}
		}
		else{
			if (rightChild != null) rightChild.insert(node);
		    else{ 
		    	rightChild = node;
		    	rightChild.parent = this;
		    	rightChild.name = (this.name + "1");
		    }
		}
	}
	
	@Override
	protected void binarySearch(Node node){
		if(node.value == value) {
			searchNode = this;
			return;
		}
		
		if (node.value < value) {
			if (leftChild != null) leftChild.binarySearch(node);
		}
		else {
			if (rightChild != null) rightChild.binarySearch(node);
		}
	}
	
}
