package binarytree.container;

import java.util.ArrayList;

import binarytree.node.Node;

public class NodesContainer implements Containerable {
	private ArrayList<Node> nodes;
	
	public NodesContainer() {
		nodes = new ArrayList<>();
	}
	
	@Override
	public void function(Node node) {
		nodes.add(node);
	}

	public ArrayList<Node> getNodes(){
		return nodes;
	}
}
