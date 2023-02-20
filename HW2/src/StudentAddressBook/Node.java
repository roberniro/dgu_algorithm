package StudentAddressBook;

public class Node <K, I> {
	private K	 		key;
	private I			item;
	private Node<K, I>	left;
	private Node<K, I>	right;
	private int 		height;
	public Node(K newKey, I newItem, int newHeight) { // 생성자
		key = newKey;
		item = newItem;
		height = newHeight; 
		left = right = null;
	}
	
	public K				getKey()						{return key;}
	public I				getItem() 						{return item;}	
	public Node<K, I>		getLeft() 						{return left;}
	public Node<K, I>		getRight()						{return right;}
	public int 				getHeight()						{return height;}
	public void				setKey(K newKey)				{key = newKey;}
	public void 			setItem(I newItem)		 		{item = newItem;}
	public void 			setLeft(Node<K, I> lt) 			{left = lt;}	
	public void 			setRight(Node<K, I> rt) 		{right = rt;}
	public void				setHeight(int newHeight)		{height = newHeight;}
}
