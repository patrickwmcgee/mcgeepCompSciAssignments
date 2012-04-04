package generalTree;

public class Tree<T>
{
	private TreeNode<T> root;

	public Tree()
	{
		this.root=null;
	}
	public Tree(TreeNode<T> root)
	{
		super();
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
	
}
