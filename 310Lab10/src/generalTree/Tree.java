package generalTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree<T>
{
	private TreeNode<T> root;

	public Tree()
	{
		this.root = null;
	}

	public Tree(TreeNode<T> root)
	{
		this.root = root;
	}

	public TreeNode<T> getRoot()
	{
		return root;
	}

	public void setRoot(TreeNode<T> root)
	{
		this.root = root;
	}

	public Tree<T> copy()
	{
		if (isEmpty())
			return (new Tree<T>());
		else
			return (new Tree<T>(root.copy()));
	}

	public boolean isEmpty()
	{
		if (root == null)
			return true;
		else
			return false;
	}

	public void clear()
	{
		root = null;
	}

	public void levelOrder()
	{
		levelOrder(root);
	}

	private void levelOrder(TreeNode<T> node)
	{
		Queue<TreeNode<T>> nodeQueue = new LinkedList<TreeNode<T>>();
		TreeNode<T> next;
		if (node != null)
			nodeQueue.add(node);
		while (!nodeQueue.isEmpty())
		{
			next = nodeQueue.remove();
			System.out.print(next.getData() + ", ");
			if (next.hasChildren())
			{
				for (TreeNode<T> tempNode : next.getChildren())
					nodeQueue.add(tempNode);
			}
		}
	}

	public void preOrder()
	{
		preOrder(root);
	}

	private void preOrder(TreeNode<T> node)
	{
		if (node != null)
		{
			if (node.hasChildren())
			{
				for (TreeNode<T> tempNode : node.getChildren())
				{
					System.out.print(tempNode.getData() + ", ");
					preOrder(tempNode);
				}
			}
		}

	}

	public static void main(String[] args)
	{
		Tree<String> tree = new Tree<String>();
		System.out.println("Is the tree of Strings empty? : " + (tree.isEmpty() ? "Tree is empty" : "Tree is not empty"));

		tree.setRoot(new TreeNode<String>("President"));
		TreeNode<String> currentNode = tree.getRoot();
		List<TreeNode<String>> list = new ArrayList<TreeNode<String>>();
		list.add(new TreeNode<String>("VP of Academics"));
		list.add(new TreeNode<String>("VP of Buisness"));
		list.add(new TreeNode<String>("VP of Studen Affairs"));
		currentNode.setChildren(list);

		// First Child
		currentNode = tree.getRoot().getChildren().get(0);
		list = new ArrayList<TreeNode<String>>();
		list.add(new TreeNode<String>("Dean of Science"));
		list.add(new TreeNode<String>("Dean of Buisness"));
		list.add(new TreeNode<String>("Dean of Engineering"));
		currentNode.setChildren(list);

		// Second Child
		currentNode = tree.getRoot().getChildren().get(1);
		list = new ArrayList<TreeNode<String>>();
		list.add(new TreeNode<String>("Buisness Chair"));
		list.add(new TreeNode<String>("Buisness Head"));
		currentNode.setChildren(list);

		// Third Child
		currentNode = tree.getRoot().getChildren().get(2);
		list = new ArrayList<TreeNode<String>>();
		list.add(new TreeNode<String>("Dean of Students"));
		list.add(new TreeNode<String>("Chair of Student Affairs"));
		currentNode.setChildren(list);

		System.out.println("Level Order Traversal");
		tree.levelOrder();
		System.out.println("\nPre Order Traversal");
		tree.preOrder();

		Tree<String> copyTree = new Tree<String>();
		copyTree = tree.copy();
		tree.clear();
		System.out.println("\nIs the tree of Strings empty? : " + (tree.isEmpty() ? "Tree is empty" : "Tree is not empty"));
		System.out.println("Is the copied tree of Strings empty? : " + (copyTree.isEmpty() ? "Tree is empty" : "Tree is not empty"));
		System.out.println("Level Order Traversal");
		copyTree.levelOrder();
		System.out.println("\nPre Order Traversal");
		copyTree.preOrder();
	}

}
