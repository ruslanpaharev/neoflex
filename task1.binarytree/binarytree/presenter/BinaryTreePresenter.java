package binarytree.presenter;

import java.util.ArrayList;
import java.util.Scanner;

import binarytree.entity.NodeEntity;
import binarytree.worker.BinaryTreeWorker;

public class BinaryTreePresenter {
	private Scanner sc;
	private int operationNumber;
	private int stopIndex = 15;
	private NodeEntity node;
	private ArrayList<NodeEntity> nodes;
	private BinaryTreeWorker worker;
	
	public BinaryTreePresenter(){
		operationNumber = 0;
		sc = new Scanner(System.in);
		worker = new BinaryTreeWorker(getStringName(), getIntegerValue());
	}
	
	public void start(){
		while (operationNumber != stopIndex) {
			printMenu();
		}
	}
	
	public int getIntegerValue(){
		int value = 0;
		
		System.out.print("Input integer value of Node: ");
		
		try{
			value = Integer.parseInt(sc.nextLine());
		}
		catch(Exception ex){
			System.out.println("Error! Node set default value (0)");
		}
		
		return value;
	}
	
	public String getStringName(){		
		System.out.print("Input name of Node: ");
		return sc.nextLine();
	}
	
	public void printMenu(){
		System.out.print("\n");
		
		System.out.println("Main menu (list of operation): ");
		System.out.println("1. Show current Node");
		System.out.println("2. Show all Nodes");
		
		System.out.println("3. Add new Node");
		System.out.println("4. Add Left Child");
		System.out.println("5. Add Right Child");
		
		System.out.println("6. Move to parent Node");
		System.out.println("7. Move to Left Child");
		System.out.println("8. Move to Right Child");
		System.out.println("9. Remove Left Child");
		System.out.println("10. Remove Right Child");
		
		System.out.println("11. Find Node by name (set it as current)");
		System.out.println("12. Find Node by value (set it as current)");
		System.out.println("13. Find value by Node name (get a integer value)");
		
		System.out.println("14. Sort Nodes by Values");
		System.out.println("15. Exit");
		
		System.out.print("Input number of operation: ");
		
		try{
			operationNumber = Integer.parseInt(sc.nextLine());
		}
		catch(Exception ex){
			operationNumber = 0;
		}
		
		System.out.print("\n");
		
		switch (operationNumber) {
        	case 1:  showCurrentNode();
                 break;
        	case 2:  showAllNodes();
                 break;
        	case 3:  addNewNode();
            	break;
        	case 4:  addLeftChild();
                 break;
        	case 5:  addRightChild();
            	break;
        	case 6:  moveToParentNode();
            	break;
        	case 7:  moveToLeftChild();
                 break;
        	case 8:  moveToRightChild();
                 break;
        	case 9:  removeLeftChild();
                 break;
        	case 10:  removeRightChild();
                 break;
        	case 11:  getNodeByName();
            	break;
        	case 12:  getNodeByValue();
            	break;
        	case 13:  getValueByNodeName();
            	break;
        	case 14:  sortNodes();
                 break;
        	case 15:  System.out.print("Program was finished! Good by!");
                 break;
        	default: System.out.println("Error! Unknown command number!");
                 break;
		}
	}
	
	public void showCurrentNode(){
		node = worker.getCurrentNode();
		System.out.println("CurrentNode---> Name: " + node.getName() + ", Value: " + node.getValue());
	}
		
	public void showAllNodes(){
		System.out.println("All existing Nodes:\n");
		nodes = worker.getAllNodes();
		
		for(NodeEntity item : nodes){
			System.out.println("Name: " + item.getName() + ", Value: " + item.getValue());
		}
	}
		
	public void addNewNode(){
		worker.addNewNode(getIntegerValue());
		System.out.println("New Node was added!");
	}
	
	public void addLeftChild(){
		worker.addLeftChild(getIntegerValue());
		System.out.println("Left Child was added!");
	}
	
	public void addRightChild(){
		worker.addRightChild(getIntegerValue());
		System.out.println("Right Child was added!");
	}
	
	public void moveToParentNode(){
		if(!worker.moveToParentNode()) {
			System.out.println("Node is not has a Parent! This is the ROOT Node!");
		}
				
		showCurrentNode();
	}
	
	public void moveToLeftChild(){
		if(!worker.moveToLeftChild()) {
			System.out.println("Node is not has a Left Child!");
		}
				
		showCurrentNode();
	}
	
	public void moveToRightChild(){
		if(!worker.moveToRightChild()) {
			System.out.println("Node is not has a Right Child!");
		}
				
		showCurrentNode();
	}
	
	public void removeLeftChild(){
		worker.removeLeftChild();
		System.out.println("Left Child was removed!");
	}
	
	public void removeRightChild(){
		worker.removeRightChild();
		System.out.println("Right Child was removed!");
	}
	
	public void getNodeByName(){
		if(worker.getNodeByName(getStringName())) {
			showCurrentNode();
		}
		else System.out.println("Result is not found!");
	}
	
	public void getNodeByValue(){
		if(worker.getNodeByValue(getIntegerValue())) {
			showCurrentNode();
		}
		else System.out.println("Result is not found!");
	}
	
	public void getValueByNodeName(){
		String name = getStringName();
		
		try{
			node = worker.getValueByNodeName(name);
			System.out.println("Result of find---> Name: " + node.getName() + ", Value: " + node.getValue());
		}
		catch(NullPointerException ex){
			System.out.println("Result is not found!");
		}
	}
	
	public void sortNodes(){
		worker.sortNodes();
		showAllNodes();
	}
}
