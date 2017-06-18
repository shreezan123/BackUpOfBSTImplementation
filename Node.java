
public class Node {
	int data;
	Node left;
	Node right;
	/*
	 * Constructor if in which a value is passed, a Node 
	 * class will be created with no pointers to left and right
	 * and with a certain value
	 */
	public Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	public void setLeft(Node node){
		this.left = node;
	}
	public void setRight(Node node){
		this.right = node;
	}
	public Node getLeft(){
		return this.left;
	}
	public Node getRight(){
		return this.right;
	}
	public int getData(){
		return this.data;
	}
	
}



