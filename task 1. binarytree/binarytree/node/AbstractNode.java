package binarytree.node;

public abstract class AbstractNode {
	
	protected int value;
	protected String name;
	protected Node parent;
	protected Node leftChild;
	protected Node rightChild;
			
	public Node getParent(){
		return parent;
	}
	
	public Node getLeftChild(){
		return leftChild;
	}
	
	public Node getRightChild(){
		return rightChild;
	}
	
	public String getName(){
		return name;
	}
	
	public int getValue(){
		return value;
	}
	
	public void removeLeftChild(){
		leftChild = null;
	}
	
	public void removeRightChild(){
		rightChild = null;
	}
}
