import java.util.ArrayList;

public class BSTMain {
	public static void main (String[] args){
		BinarySearchTree tree = new BinarySearchTree();
		//Node node1 = new Node(10);
		//System.out.println(node1);
		tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.printtree();
        System.out.println(tree.find(80));
        System.out.println(tree.numLessthan(100000)); 
        tree.delete(60);
        System.out.println();
        tree.printtree();
	}
	
public class BinarySearchTree {
	
	public static class Node {
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
	
	Node root;
	ArrayList<Integer> listlessthan = new ArrayList<Integer>();
	public BinarySearchTree(){
		this.root = null; //set the root as null and then populate the root in insert function
	}
/*
 * if there is no node with a value, create a new node with the given value.
 */
	void insert (int data){
		root = insertNode(root, data);
	}
	
	public Node insertNode(Node root, int data){
		if (root == null){ //this is executed at the beginning when node is instantiated  
			root = new Node(data);
		}
		if (data < root.data){
			root.left = insertNode(root.left,data);
		}
		else if (data > root.data){
			root.right = insertNode(root.right,data);
		}
		return root;
	}
	
	public boolean find(int value){
		Node temp = root;
		while (temp != null){
			if (value == temp.data){
				return true;
			}
			if (value < temp.data){
				temp = temp.left;
			}
			else if (value > temp.data){
				temp = temp.right;
			}
		}
		return false;
		 
	}
	public void printtree(){
		inorder(root);
	}
	public void inorder(Node node){
		if (node != null) {
			inorder(node.getLeft());
			System.out.print(node.getData()+ " "); 
			listlessthan.add(node.getData());
			inorder(node.getRight());
		}
	}
	public int numLessthan(int value){
		int lessnums = 0;
		for (int i = 0 ; i < listlessthan.size(); i++){
			if (listlessthan.get(i) < value){
				lessnums ++;
			}
		}
		return lessnums;
	}
	public void delete(int value){
		root = deleteNode(root, value);	
	}
	public Node deleteNode (Node root, int value){
		if (root == null){
			return root;
		}
		//considering node to be deleted is at the leaf
		if (value < root.data){
			root.left = deleteNode(root.left,value);
		}
		else if (value > root.data){
            root.right = deleteNode(root.right, value);
            }
		else{
			if (root.left == null){
				return root.right;
			}
			else if (root.right == null ){
				return root.left;
			}
			root.data = smallright(root.right);
			root.right = deleteNode(root.right, root.data);
		}
		return root;	
	}
	public int smallright(Node root){
		int temp = root.data;
		while (root.left != null){
			temp = root.left.data;
			root = root.left;
		}
		return temp;
	} 
}
//This is the main function that I created to test my implementation against some inputs

}
