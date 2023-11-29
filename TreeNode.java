public class TreeNode<T> 
{
	private T data;
	protected  TreeNode<T> leftChild;
	protected TreeNode<T> rightChild;
	
	TreeNode(T datanode) 
	{
		this.data = datanode;
		leftChild = null;
		rightChild = null;
	}
	
	TreeNode(TreeNode<T> node) {
		data = node.getData();
		leftChild = node.leftChild;
		rightChild = node.rightChild;
	}
	
	public T getData() {
		return data;
	}
}

