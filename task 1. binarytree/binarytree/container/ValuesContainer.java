package binarytree.container;

import java.util.ArrayList;

import binarytree.node.Node;

public class ValuesContainer implements Containerable {
	private ArrayList<Integer> values;
	
	public ValuesContainer() {
		values = new ArrayList<>();
	}
	
	@Override
	public void function(Node node) {
		values.add(node.getValue());
	}

	public ArrayList<Integer> getValues(){
		return values;
	}
}
