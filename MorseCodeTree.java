
import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> 
{

	TreeNode<String> root;
	
	MorseCodeTree() 
	{
		root=null;
		buildTree();
	}
	
	public TreeNode<String> getRoot() 
	{
		return root;
	}

	public void setRoot(TreeNode<String> newNode) 
	{
		root=new TreeNode<String>(newNode);
	}

	public void insert(String code, String letter)
	{
		if (root!=null) 
		{
			addNode(root, code, letter);
		}
		else if (root==null) 
		{
			root=new TreeNode<String>(letter);
		}
	}
	
	public void addNode(TreeNode<String> root, String code, String letter) 
	{
		if (code.length()>1) 
		{
			if (code.charAt(0)=='-') 
			{
				addNode(root.rightChild, code.substring(1), letter);
			}
			else if (code.charAt(0)=='.') 
			{
				addNode(root.leftChild, code.substring(1), letter);
			}
		}
		else 
		{
			if (code.charAt(0)=='-') 
			{
				
				root.rightChild = new TreeNode<String>(letter);
			}
			else if (code.charAt(0)=='.') 
			{
				root.leftChild = new TreeNode<String>(letter);
			}
		}
		
	}

	public String fetch(String code) 
	{
		return fetchNode(root, code);
	}
	
	public String fetchNode(TreeNode<String> root, String code)
	{
		String letter = "";
		if (code.length()>1) 
		{
			if (code.charAt(0)=='-') 
			{
				letter = fetchNode(root.rightChild, code.substring(1));		
			}
			else if (code.charAt(0)=='.') 
			{
				letter = fetchNode(root.leftChild, code.substring(1));
			}
		}
		else
		{
			if (code.charAt(0)=='-') 
			{
				letter = root.rightChild.getData();
			}
			else if (code.charAt(0)=='.') 
			{
				letter = root.leftChild.getData();
			}
		}
		
		return letter;
	}
	
	public MorseCodeTree delete(String data) throws UnsupportedOperationException 
	{
		throw new UnsupportedOperationException();
	}
	
	public MorseCodeTree update() throws UnsupportedOperationException 
	{
		throw new UnsupportedOperationException();
	}
	
	public void buildTree()
	{
		//Root
		insert("","");
		//Level 1
		insert(".","E"); insert("-","T");
		//Level 2
		insert ("..","I"); insert(".-","A"); insert("-.","N"); insert("--","M");
		//Level 3
		insert("...","S"); insert("..-","U"); insert(".-.","R"); insert(".--","W"); insert("-..","D"); insert("-.-","K"); insert("--.","G"); insert("---","O");
		//Level 4
		insert("....","H"); insert("...-","V"); insert("..-.","F"); insert(".-..","L");insert(".--.","P"); insert(".---","J"); insert("-...","B"); insert("-..-","X"); insert("-.-.","C"); insert("-.--","Y"); insert("--..","Z"); insert("--.-","Q");
	}
	
	public ArrayList<String> toArrayList() 
	{
		ArrayList<String> List = new ArrayList<String>();
		LNRoutputTraversal(root,List);
		return List;
	}
	
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list)
	{
		if (root.leftChild == null && root.rightChild == null) 
		{
			list.add(root.getData());
		}
		else
		{
			if (root.leftChild != null) 
			{
				LNRoutputTraversal(root.leftChild,list);
				list.add(root.getData());
			}
		
			if (root.rightChild != null) 
			{
				LNRoutputTraversal(root.rightChild,list);
			}
		}

	}
}