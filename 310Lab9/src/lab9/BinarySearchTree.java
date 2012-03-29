/*
 * BinarySearchTree.java
 * written by mcgeep for Lab9
 */
package lab9;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T>
{
	public BinarySearchTree()
	{
		super();
	}

	public BinarySearchTree(BinaryNode<T> rootEntry)
	{
		super(rootEntry);
	}

	public BinaryNode<T> search(T entry)
	{
		return search(getRoot(), entry);
	}

	private BinaryNode<T> search(BinaryNode<T> rootNode, T entry)
	{
		BinaryNode<T> result = null;
		if (rootNode != null)
		{
			if (entry == rootNode.getData())
			{
				result = rootNode;
			}
			else if (entry.compareTo(rootNode.getData()) < 0)
			{
				result = search(rootNode.getLeft(), entry);
			}
			else
			{
				result = search(rootNode.getRight(), entry);
			}
		}

		return result;
	}

	public boolean contains(T entry)
	{
		return search(entry) != null;
	}

	public boolean add(T newEntry)
	{
		if (newEntry == null)
			return false;
		else
		{
			return add(getRoot(), newEntry);
		}
	}

	private boolean add(BinaryNode<T> rootNode, T newEntry)
	{
		boolean result = false;
		int comparison = newEntry.compareTo(rootNode.getData());

		if (comparison == 0)
		{
			result = false; // the element is the same and is not added
		}
		else if (comparison < 0)
		{
			if (rootNode.hasLeft())
			{
				result = add(rootNode.getLeft(), newEntry);
			}
			else
			{
				rootNode.setLeft(new BinaryNode<T>(newEntry));
				result = true;
			}
		}
		else if (comparison > 0)
		{
			if (rootNode.hasRight())
			{

				result = add(rootNode.getRight(), newEntry);
			}
			else
			{
				rootNode.setRight(new BinaryNode<T>(newEntry));
				result = true;
			}
		}
		return result;
	}

	public static void levelorderTraverse(BinaryNode<?> n)
	{
		Queue<BinaryNode<?>> nodequeue = new LinkedList<BinaryNode<?>>();

		if (n != null)
			nodequeue.add(n);
		while (!nodequeue.isEmpty())
		{
			BinaryNode<?> next = nodequeue.remove();
			System.out.print(next.getData() + " ");
			if (next.getLeft() != null)
			{
				nodequeue.add(next.getLeft());
			}
			if (next.getRight() != null)
			{
				nodequeue.add(next.getRight());
			}
		}
	}

	public BinaryNode<T> findMax()
	{
		if (isEmpty())
			return null;
		return findMax(getRoot());
	}

	private BinaryNode<T> findMax(BinaryNode<T> rootNode)
	{
		if (rootNode == null)
			return null;
		if (rootNode.hasRight())
		{
			rootNode = findMax(rootNode.getRight());
		}
		return rootNode;
	}

	public BinaryNode<T> findMin()
	{

		if (isEmpty())
			return null;
		return findMin(getRoot());
	}

	private BinaryNode<T> findMin(BinaryNode<T> rootNode)
	{
		if (rootNode == null)
			return null;
		if (rootNode.hasLeft())
		{
			rootNode = findMin(rootNode.getLeft());
		}
		return rootNode;
	}

	public static void main(String args[])
	{
		System.out.println("Test for Integers: ");

		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree();

		System.out.println("Is the tree of Integers empty? : " + (binarySearchTree.isEmpty() ? "Tree is empty" : "Tree is not empty"));
		System.out.println("Does the tree contain 15? " + (binarySearchTree.contains(15) ? "Yes" : "No"));
		System.out.println("Does the tree contain 50? " + (binarySearchTree.contains(50) ? "Yes" : "No"));
		System.out.println("Does the tree contain 7? " + (binarySearchTree.contains(7) ? "Yes" : "No"));
		binarySearchTree.setRoot(new BinaryNode<Integer>(30));
		System.out.println("Adding values to tree");
		binarySearchTree.add(10);
		binarySearchTree.add(15);
		binarySearchTree.add(50);
		binarySearchTree.add(7);
		binarySearchTree.add(5);
		System.out.println("Does the tree contain 10? " + (binarySearchTree.contains(10) ? "Yes" : "No"));
		System.out.println("Does the tree contain 15? " + (binarySearchTree.contains(15) ? "Yes" : "No"));
		System.out.println("Does the tree contain 50? " + (binarySearchTree.contains(50) ? "Yes" : "No"));
		System.out.println("Does the tree contain 7? " + (binarySearchTree.contains(7) ? "Yes" : "No"));
		System.out.println("Does the tree contain 5? " + (binarySearchTree.contains(5) ? "Yes" : "No"));
		System.out.println("Does the tree contain 53? " + (binarySearchTree.contains(53) ? "Yes" : "No"));
		System.out.println("Does the tree contain 27? " + (binarySearchTree.contains(27) ? "Yes" : "No"));
		System.out.println("The max number in the tree is: " + binarySearchTree.findMax().getData());
		System.out.println("The min number in the tree is: " + binarySearchTree.findMin().getData());
		System.out.println("The height of the tree is: " + binarySearchTree.getHeight());
		System.out.print("Level order traverse of the Integer tree: ");
		binarySearchTree.levelorderTraverse(binarySearchTree.getRoot());

		System.out.println("\nTest for Strings: ");

		BinarySearchTree<String> binarySearchTreeString = new BinarySearchTree();
		
		System.out.println("Is the tree of Strings empty? : " + (binarySearchTreeString.isEmpty() ? "Tree is empty" : "Tree is not empty"));
		System.out.println("Does the tree contain 15? " + (binarySearchTreeString.contains("John") ? "Yes" : "No"));
		System.out.println("Does the tree contain 50? " + (binarySearchTreeString.contains("Sue") ? "Yes" : "No"));
		System.out.println("Does the tree contain 7? " + (binarySearchTreeString.contains("Larry") ? "Yes" : "No"));
		binarySearchTreeString.setRoot(new BinaryNode<String>("Kevin"));
		System.out.println("Adding values to tree");
		binarySearchTreeString.add("John");
		binarySearchTreeString.add("Sue");
		binarySearchTreeString.add("Larry");
		binarySearchTreeString.add("Mike");
		binarySearchTreeString.add("Abe");
		System.out.println("Does the tree contain John? " + (binarySearchTreeString.contains("John") ? "Yes" : "No"));
		System.out.println("Does the tree contain Sue? " + (binarySearchTreeString.contains("Sue") ? "Yes" : "No"));
		System.out.println("Does the tree contain Larry? " + (binarySearchTreeString.contains("Larry") ? "Yes" : "No"));
		System.out.println("Does the tree contain Mike? " + (binarySearchTreeString.contains("Mike") ? "Yes" : "No"));
		System.out.println("Does the tree contain Abe? " + (binarySearchTreeString.contains("Abe") ? "Yes" : "No"));
		System.out.println("Does the tree contain Ben? " + (binarySearchTreeString.contains("Ben") ? "Yes" : "No"));
		System.out.println("Does the tree contain Carl? " + (binarySearchTreeString.contains("Carl") ? "Yes" : "No"));
		System.out.println("The largest value string in the tree is: " + binarySearchTreeString.findMax().getData());
		System.out.println("The smalles value string in the tree is: " + binarySearchTreeString.findMin().getData());
		System.out.println("The height of the tree is: " + binarySearchTreeString.getHeight());

		System.out.print("Level order traverse of the String tree: ");
		binarySearchTreeString.levelorderTraverse(binarySearchTreeString.getRoot());
	}

}
