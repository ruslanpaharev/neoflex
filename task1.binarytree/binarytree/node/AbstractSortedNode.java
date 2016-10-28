package binarytree.node;

import java.util.ArrayList;

public abstract class AbstractSortedNode extends AbstractFunctionalNode{
	
	protected static Node searchNode;
	protected abstract void insert(Node node);
	protected abstract void binarySearch(Node node);
	
	public void addNode(int value){
		if(parent != null) parent.addNode(value);
		else insert(new Node(value));
	}
		
	public void sort(){
		if(parent != null) parent.sort();
		else{		
			ArrayList<Node> nodes = getNodes();
			
			removeLeftChild();
			removeRightChild();
									
			for(Node item : nodes){
				if(item.parent != null){
					insert(new Node(item.getName(), item.getValue()));
				} 
			}
			
		}		
	}
	
	public Node getNodeByValue(int value) throws NullPointerException {
		searchNode = null;
		
		if(parent != null) parent.getNodeByValue(value);
		else {
			binarySearch(new Node(value));
		}
		
		return searchNode;
	}
}
