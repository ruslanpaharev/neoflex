package binarytree;

import java.util.ArrayList;
import java.util.Comparator;

public class Node {
	private Node parent; // why we must use link to parent node? //
	private Node left_child;
	private Node right_child;
	private String name;
	private int value;
	
	private static Node nodeItem;
	private static ArrayList<String> names;
	private static ArrayList<Integer> values;
	private static ArrayList<Node> nodes;
	
	public Node(String name, int value) {
		this.name = name;
		this.value = value;
		names = new ArrayList<>();
		values = new ArrayList<>();
		nodes = new ArrayList<>();
	}
	
	public String getName(){
		return name;
	}
	
	public int getValue(){
		return value;
	}
	
	public Node getLeftChild(){
		return left_child;
	}
	
	public Node getRightChild(){
		return right_child;
	}
		
	public void addLeftChild(int value){
		left_child = new Node(this.name + "0", value);
	}
	
	public void addRightChild(int value){
		right_child = new Node(this.name + "1", value);
	}	
	
	public void removeLeftChild(){
		left_child = null;
	}
	
	public void removeRightChild(){
		right_child = null;
	}
	
	private void move(Functional func){
		if(left_child != null) left_child.move(func);
		
		func.function(this);
										
		if(right_child != null) right_child.move(func);
	}
		
	public ArrayList<String> getNames(){
		names.clear();
		
		move(new Functional() {
			@Override
			public void function(Node node) {
				names.add(node.getName());
			}
		});
		
		return names;
	}
	
	public ArrayList<Integer> getValues(){
		values.clear();
		
		move(new Functional() {
			@Override
			public void function(Node node) {
				values.add(node.getValue());
			}
		});
		
		return values;
	}
	
	private ArrayList<Integer> getSortedValues(Comparator<Integer> comp){
		ArrayList<Integer> sortedValues = new ArrayList<>();
		sortedValues = getValues();				
		sortedValues.sort(comp);
		return sortedValues;
	}
	
	public ArrayList<Integer> getSortedValuesByAscending(){
		Comparator<Integer> comp = (Integer a, Integer b) -> {
		    return a.compareTo(b);
		};
		
		return getSortedValues(comp);
	}
	
	public ArrayList<Integer> getSortedValuesByDescending(){
		Comparator<Integer> comp = (Integer a, Integer b) -> {
		    return b.compareTo(a);
		};
		
		return getSortedValues(comp);
	}
	
	public ArrayList<Node> getNodes(){
		nodes.clear();
	
		move(new Functional() {
			@Override
			public void function(Node node) {
				nodes.add(node);
			}
		});
		
		return nodes;
	}
	
	public Node getNodeByName(String name) throws NullPointerException {
		nodeItem = null;
		
		move(new Functional() {
			@Override
			public void function(Node node) {
				if(name.equalsIgnoreCase(node.getName())){
					nodeItem = node;
				}
			}
		});
		
		return nodeItem;
	}
	
	public int getValueByNodeName(String name) throws NullPointerException {
		return getNodeByName(name).getValue();
	}
}
