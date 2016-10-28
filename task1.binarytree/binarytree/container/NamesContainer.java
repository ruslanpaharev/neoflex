package binarytree.container;

import java.util.ArrayList;

import binarytree.node.Node;

public class NamesContainer implements Containerable {
	private ArrayList<String> names;
	
	public NamesContainer() {
		names = new ArrayList<>();
	}
	
	@Override
	public void function(Node node) {
		names.add(node.getName());
	}
	
	public ArrayList<String> getNames(){
		return names;
	}
}
