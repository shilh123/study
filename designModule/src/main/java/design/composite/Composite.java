package design.composite;

import java.util.Enumeration;
import java.util.Vector;
/**
 * 
 * @author Shilh
 * 组合模式（Composite）
 */
public class Composite {
	public static void main(String[] args) {
		Tree tree = new Tree("A");
		TreeNode nodeB = new TreeNode("B");
		TreeNode nodeC = new TreeNode("C");
		nodeB.add(nodeC);
		tree.root.add(nodeB);
		System.out.println("==============");
	}
}

class TreeNode{
	private String name;
	private TreeNode parent;
	private Vector<TreeNode> children = new Vector<TreeNode>();
	public TreeNode(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TreeNode getParent() {
		return parent;
	}
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	public void add(TreeNode node) {
		children.add(node);
	}
	
	public void remove(TreeNode node) {
		children.remove(node);
	}
	
	public Enumeration<TreeNode> getChildren() {
		return children.elements();
	}
	
}

class Tree{
	TreeNode root = null;
	
	public Tree(String name) {
		// TODO Auto-generated constructor stub
		root = new TreeNode(name);
	}	
}

