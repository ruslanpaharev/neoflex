package binarytree.container;

import binarytree.node.Node;

public class NodeContainer implements Containerable{
	private Node node;
	private String name;
	
	public NodeContainer(String name) {
		this.node = null;
		this.name = name;
	}
	
	@Override
	public void function(Node node) {
		if(name.equalsIgnoreCase(node.getName())){
			this.node = node;
		}
	}

	public Node getNode(){
		return node;
	}
}
