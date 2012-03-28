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
		if (currentNode == null)
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
		return root.getHeight();
	}

	public int getNumNodes()
	{
		return root.getNumNodes();
	}

	public int getNumLeaves()
	{
		return root.getNumLeaves();
	}

	public BinaryTree<T> copy()
	{
		if(isEmpty())
			return(new BinaryTree<T>());
		else
			return(new BinaryTree<T>(root.copy()));
	}

	private class LevelOrderIterator implements Iterator<T>
	{
		private Queue<BinaryNode<T>> nodeQueue;

		public LevelOrderIterator()
		{
			nodeQueue = new LinkedList<BinaryNode<T>>();
			if (root != null)
			{
					nodeQueue.add(root);
			}
		}

		public T next()
		{
			BinaryNode<T> nextNode;
			if (hasNext())
			{
				nextNode = nodeQueue.remove();
				BinaryNode<T> leftChild = nextNode.getLeft();
				BinaryNode<T> rightChild = nextNode.getRight();

				if (leftChild!=null)
				{
					nodeQueue.add(leftChild);
				}
			}
			else
			{
				throw new NoSuchElementException();
			}
			return nextNode.getData();
		}

		@Override
		public boolean hasNext()
		{
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void remove()
		{
			// TODO Auto-generated method stub

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
		System.out.println("The height of the tree is: " + binaryTree.getHeight());

		System.out.println("The number of nodes is: " + binaryTree.getNumNodes());
		
		BinaryTree<Integer> newTree=new BinaryTree();
	newTree.copy();
		// System.out.println("The number of leaves is: " +
		// binaryTree.getNumLeaves());
	}
}
