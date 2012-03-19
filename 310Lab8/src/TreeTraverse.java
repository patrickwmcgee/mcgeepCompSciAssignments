import java.util.LinkedList;
import java.util.Queue;

public class TreeTraverse<T>
{
	private BinaryNode<T> root;
	
	private static class BinaryNode<T>
	{
		private T data;
		private BinaryNode<T> left;
		private BinaryNode<T> right;

		public BinaryNode(T Data)
		{
			data = Data;
		}

		public T getData()
		{
			return data;
		}

		public BinaryNode<T> getLeft()
		{
			return left;
		}

		public BinaryNode<T> getRight()
		{
			return right;
		}

		public void setData(T Data)
		{
			data = Data;
		}

		public void setLeft(BinaryNode<T> Left)
		{
			left = Left;
		}

		public void setRight(BinaryNode<T> Right)
		{
			right = Right;
		}

		// public void inorderTraverse()
		// {
		// inorderTraverse(root);
		// }

	}

	public static void inorderTraverse(BinaryNode<?> node)
	{
		if(node != null)
		{
			inorderTraverse((BinaryNode)node.getLeft());
			System.out.print(node.getData()+ " ");
			inorderTraverse((BinaryNode)node.getRight());
		}
	}
	
	public static void preorderTraverse(BinaryNode<?> node)
	{
		if(node!=null)
		{
			System.out.print(node.getData() + " ");
			preorderTraverse(node.getLeft());
			preorderTraverse(node.getRight());
		}
	}
	
	public static void postorderTraverse(BinaryNode<?> node)
	{
		if(node!= null)
		{
			postorderTraverse(node.getLeft());
			postorderTraverse(node.getRight());
			System.out.print(node.getData() + " ");
		}
		
	}
	public static void levelorderTraverse(BinaryNode<?> n)
	{
		Queue<BinaryNode<?>> nodequeue = new LinkedList<BinaryNode<?>>();

		if (n != null)
			nodequeue.add(n);
		while (!nodequeue.isEmpty())
		{
			BinaryNode<?> next = nodequeue.remove();
			System.out.print(next.data + " ");
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
	public static void main(String[] args)
	{
		
		//Create all of the nodes with the values
		BinaryNode<Integer> one = new BinaryNode<Integer>(1);
		BinaryNode<Integer> two = new BinaryNode<Integer>(2);
		BinaryNode<Integer> three = new BinaryNode<Integer>(3);
		BinaryNode<Integer> four = new BinaryNode<Integer>(4);
		BinaryNode<Integer> five = new BinaryNode<Integer>(5);
		BinaryNode<Integer> six = new BinaryNode<Integer>(6);
		BinaryNode<Integer> seven = new BinaryNode<Integer>(7);
		BinaryNode<Integer> eight = new BinaryNode<Integer>(8);
		BinaryNode<Integer> nine = new BinaryNode<Integer>(9);
	
		
		//Create the tree by ordering the nodes using the setLeft and setRight methods
		
		//First level
		one.setLeft(two);
		one.setRight(three);
		
		//Second level
		two.setLeft(four);
		two.setRight(five);
		
		three.setLeft(six);
		
		//Third level
		four.setLeft(seven);
		
		six.setLeft(eight);
		six.setRight(nine);
		
		//Do the traversals
		
		System.out.println("Preorder Traversal");
		preorderTraverse(one);
		
		System.out.println("\nInorder Traversal");
		inorderTraverse(one);
		
		System.out.println("\nPostorder Traversal");
		postorderTraverse(one);
		
		System.out.println("\nLevel-order Traversal");
		levelorderTraverse(one);
		
		
		
		
	}

}
