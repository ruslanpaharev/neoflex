package binarytree.entity;

public class NodeEntity {
	private int value;
	private String name;
	
	public NodeEntity(String name, int value){
		this.name = name;
		this.value = value;
	}
	
	public String getName(){
		return name;
	}
	
	public int getValue(){
		return value;
	}
}
