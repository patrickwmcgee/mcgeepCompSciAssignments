/*
 * BinaryTree.java
 * written by mcgeep for Lab9
 */
package lab9;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BinaryTree<T>
{
	private BinaryNode<T> root;
	private BinaryNode<T> currentNode;

	public BinaryTree(BinaryNode<T> root)
	{
		this.root = root;
		currentNode = root;
	}

	public BinaryTree()
	{
		this.root = null;
		currentNode = null;
	}

	public BinaryNode<T> getRoot()
	{
		return root;
	}

	public void setRoot(BinaryNode<T> root)
	{
		this.root = root;
	}

	public BinaryNode<T> getCurrentNode()
	{
		return currentNode;
	}

	public void setCurrentNode(BinaryNode<T> currentNode)
	{
		this.currentNode = currentNode;
	}

	public void advanceLeft()
	{
		if (currentNode.hasLeft())
		{
			currentNode = currentNode.getLeft();
		}
	}

	public void advanceRight()
	{
		if (currentNode.hasRight())
		{
			currentNode = currentNode.getRight();
		}
	}

	public void resetCurrentNode()
	{
		currentNode = root;
	}

	public boolean isEmpty()
	{
		if (root == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public int getHeight()
	{
		if (root == null)
		{
			return 0;
		}
		else
		{
			return root.getHeight();
		}
	}

	public int getNumNodes()
	{
		if (root == null)
		{
			return 0;
		}
		else
		{
			return root.getNumNodes();
		}
	}

	public int getNumLeaves()
	{
		if (root == null)
		{
			return 0;
		}
		else
		{
			return root.getNumLeaves();
		}
	}

	public BinaryTree<T> copy()
	{
		if (isEmpty())
			return (new BinaryTree<T>());
		else
			return (new BinaryTree<T>(root.copy()));
	}

	public void clear()
	{
		this.setRoot(null);
	}

	public LevelOrderIterator getIterator()
	{
		return new LevelOrderIterator();
	}

	private class LevelOrderIterator implements Iterator<T>
	{
		BinaryNode<T> next;
		Queue<BinaryNode<T>> nodeQueue = new LinkedList<BinaryNode<T>>();

		public LevelOrderIterator()
		{
			next = root;
			nodeQueue.add(next);
		}

		public boolean hasNext()
		{
			return !nodeQueue.isEmpty();
		}

		public T next()
		{

			if (hasNext())
			{
				next = nodeQueue.poll();
				if (next.hasLeft()==true)
				{
					nodeQueue.add(next.getLeft());
				}

				if (next.hasRight()==true)
				{
					nodeQueue.add(next.getRight());
				}
			}
			else
			{
				throw new NoSuchElementException();
			}
			return next.getData();
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}

	}

	public static void main(String args[])
	{
		BinaryTree<Integer> binaryTree = new BinaryTree(new BinaryNode(15));

		binaryTree.getRoot().setLeft(new BinaryNode(7));
		binaryTree.getRoot().setRight(new BinaryNode(30));

		binaryTree.getRoot().getLeft().setLeft(new BinaryNode(4));
		binaryTree.getRoot().getLeft().getLeft().setLeft(new BinaryNode(1));
		binaryTree.getRoot().getLeft().getLeft().setRight(new BinaryNode(6));

		binaryTree.getRoot().getLeft().setRight(new BinaryNode(12));
		binaryTree.getRoot().getLeft().getRight().setLeft(new BinaryNode(10));
		binaryTree.getRoot().getLeft().getRight().setRight(new BinaryNode(14));

		binaryTree.getRoot().getRight().setLeft(new BinaryNode(23));
		binaryTree.getRoot().getRight().getLeft().setLeft(new BinaryNode(19));
		binaryTree.getRoot().getRight().getLeft().setRight(new BinaryNode(27));

		binaryTree.getRoot().getRight().setRight(new BinaryNode(45));
		binaryTree.getRoot().getRight().getRight().setLeft(new BinaryNode(36));
		binaryTree.getRoot().getRight().getRight().setRight(new BinaryNode(50));

		// levelorderTraverse(binaryTree.getRoot());
		Iterator iterator = binaryTree.getIterator();
		System.out.print("Level order traverse: ");
		while (iterator.hasNext() == true)
		{
			System.out.print(iterator.next() + " ");
		}
		System.out.println();

		System.out.println("The height of the tree is: " + binaryTree.getHeight());

		System.out.println("The number of nodes is: " + binaryTree.getNumNodes());

		System.out.println("The number of leaves is: " + binaryTree.getNumLeaves());

		// copy the tree
		BinaryTree<Integer> newTree = new BinaryTree();
		newTree.setRoot(binaryTree.copy().getRoot());

		// clear the origional
		binaryTree.clear();
		System.out.println("After Clearing the origional tree");
		System.out.println("Is the origional tree empty: " + (binaryTree.isEmpty() ? "Tree is empty" : "Tree is not empty"));
		System.out.println("The height of the tree is: " + binaryTree.getHeight());

		System.out.println("The number of nodes is: " + binaryTree.getNumNodes());

		System.out.println("The number of leaves is: " + binaryTree.getNumLeaves());

		System.out.println("Is the copied tree empty: " + (newTree.isEmpty() ? "Tree is empty" : "Tree is not empty"));

		Iterator iterator2 = newTree.getIterator();
		System.out.print("Level order traverse of copy tree: ");
		while (iterator2.hasNext() == true)
		{
			System.out.print(iterator2.next() + " ");
		}
		iterator2 = newTree.getIterator();
		// binaryTree.getNumLeaves());
		System.out.println();
		System.out.println("The height of the tree is: " + newTree.getHeight());

		System.out.println("The number of nodes is: " + newTree.getNumNodes());

		System.out.println("The number of leaves is: " + newTree.getNumLeaves());
		System.out.println("Next: " + iterator2.next());
		System.out.println("Next: " + iterator2.next());
		System.out.println("Next: " + iterator2.next());
	}
}
