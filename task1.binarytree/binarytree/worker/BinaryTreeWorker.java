package binarytree.worker;

import java.util.ArrayList;

import binarytree.entity.NodeEntity;
import binarytree.node.Node;

public class BinaryTreeWorker {
	private Node root;
	private Node current;
		
	public BinaryTreeWorker(String name, int value){
		root = new Node(name, value);
		current = root;
	}
	
	public NodeEntity getCurrentNode(){
		return new NodeEntity(current.getName(), current.getValue());
	}
	
	public ArrayList<NodeEntity> getAllNodes(){
		ArrayList<NodeEntity> nodes = new ArrayList<>();
		
		for(Node item : current.getNodes()){
			nodes.add(new NodeEntity(item.getName(), item.getValue()));
		}
		
		return nodes;
	}
	
	public void addNewNode(int value){
		current.addNode(value);
	}
	
	public void addLeftChild(int value){
		current.addLeftChild(value);
	}
	
	public void addRightChild(int value){
		current.addRightChild(value);
	}
	
	public boolean moveToParentNode(){
		if(current.getParent() != null) {
			current = current.getParent();
			return true;
		}

		return false;
	}
	
	public boolean moveToLeftChild(){
		if(current.getLeftChild() != null) {
			current = current.getLeftChild();
			return true;
		}
				
		return false;
	}
	
	public boolean moveToRightChild(){
		if(current.getRightChild() != null) {
			current = current.getRightChild();
			return true;
		}
				
		return false;
	}
	
	public void removeLeftChild(){
		current.removeLeftChild();
	}
	
	public void removeRightChild(){
		current.removeRightChild();
	}
	
	public boolean getNodeByName(String name){
		Node item = current.getNodeByName(name);
		
		if(item != null) {
			current = item;
			return true;
		}

		return false;
	}
	
	public boolean getNodeByValue(int value){
		Node item = current.getNodeByValue(value);
		
		if(item != null) {
			current = item;
			return true;
		}

		return false;
	}
	
	public NodeEntity getValueByNodeName(String name) throws NullPointerException{
		NodeEntity node = null;
		
		try{
			int value = current.getValueByNodeName(name);
			node = new NodeEntity(name, value);
		}
		catch(NullPointerException ex){
			//"Result is not found";
		}
		
		return node;
	}
	
	public void sortNodes(){
		current.sort();
	}
}
