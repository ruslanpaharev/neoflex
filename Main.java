package binarytree;

public class Main {

	public static void main(String[] args) {
		Node root = new Node("root", 1);
		
		// example of creation of child nodes:
		
		root.addLeftChild(2);
		root.addRightChild(3);
		
		root.getLeftChild().addLeftChild(4);
		root.getLeftChild().addRightChild(5);
		
		root.getRightChild().addLeftChild(6);
		root.getRightChild().addRightChild(7);
		
		// get all nodes of current node:
		for(Node item : root.getNodes()){
			System.out.println(item.getName() + ": " + item.getValue());
		}
							
		System.out.println("");
		
		// get all sorted values by ascending of a current node:
		for(int item : root.getSortedValuesByAscending()){
			System.out.print(item + "\t");
		}
		
		System.out.println("");
		
		// get all sorted values by descending of a current node:
		for(int item : root.getSortedValuesByDescending()){
			System.out.print(item + "\t");
		}
		
		System.out.println("");
		
		// get all values of a current node:
		for(int item : root.getValues()){
			System.out.print(item + "\t");
		}
		
		System.out.println("\n");
		
		// find and return node by name:
		System.out.println("Name: " + root.getNodeByName("ROOT0").getName());
		
		// find and return value by node name:
		System.out.println("Value: " + root.getValueByNodeName("ROOT0"));
		
		System.out.println("");
		
		try{
			// find and return node by name:
			System.out.println("Name: " + root.getNodeByName("ROOT05454545").getName());
		}
		catch(NullPointerException ex){
			System.out.println("Error: " + ex.getMessage());
		}
						
		try{
			// find and return value by node name:
			System.out.println("Value: " + root.getValueByNodeName("ROOT043243424"));
		}
		catch(NullPointerException ex){
			System.out.println("Error: " + ex.getMessage());
		}
		
		System.out.println("");
		
		// example of remove of right child of a node:
		root.getLeftChild().removeRightChild();
		for(String str : root.getLeftChild().getNames()){
			System.out.println(str);
		}
	}

}
