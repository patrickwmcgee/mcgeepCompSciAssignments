package generalTree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T>
{
	private T data;
	private List<TreeNode<T>> children;

	public TreeNode()
	{
		data = null;
		children = null;
	}

	public TreeNode(T data, List<TreeNode<T>> children)
	{
		super();
		this.data = data;
		this.children = children;
	}

	public TreeNode(T data)
	{
		this.data = data;
		children = null;
	}

	public T getData()
	{
		return data;
	}

	public void setData(T data)
	{
		this.data = data;
	}

	public List<TreeNode<T>> getChildren()
	{
		return children;
	}

	public void setChildren(List<TreeNode<T>> children)
	{
		this.children = children;
	}

	public boolean hasChildren()
	{
		return (children != null && !children.isEmpty());
	}

	public TreeNode<T> copy()
	{
		if (this == null)
			return null;

		TreeNode<T> newRoot = new TreeNode<T>(data);

		if (this.hasChildren())
		{
			List<TreeNode<T>> listChildren = new ArrayList<TreeNode<T>>();
			for (TreeNode<T> child : this.getChildren())
			{
				listChildren.add(child.copy());

			}
			newRoot.setChildren(listChildren);
		}

		return newRoot;
	}

}
