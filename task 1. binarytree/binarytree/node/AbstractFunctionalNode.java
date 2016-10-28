package binarytree.node;

import java.util.ArrayList;

import binarytree.container.*;

public abstract class AbstractFunctionalNode extends AbstractNode{
	
	protected abstract void moveToChild(Containerable func);
	
	protected void move(Containerable func){
		if(parent != null) parent.move(func);
		else moveToChild(func);
	}
	
	public ArrayList<String> getNames(){
		NamesContainer names = new NamesContainer();
		move(names);
		
		return names.getNames();
	}
	
	public ArrayList<Integer> getValues(){
		ValuesContainer values = new ValuesContainer();
		move(values);
		
		return values.getValues();
	}
	
	public ArrayList<Node> getNodes(){		
		NodesContainer nodes = new NodesContainer();
		move(nodes);		
		
		return nodes.getNodes();
	}
	
	public Node getNodeByName(String name) throws NullPointerException {
		NodeContainer node = new NodeContainer(name);
		move(node);		
		
		return node.getNode();
	}
	
	public int getValueByNodeName(String name) throws NullPointerException {
		return getNodeByName(name).getValue();
	}
}
