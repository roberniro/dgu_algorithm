package StudentComparison;

public class SNode <E> {
	private E			item;
	private SNode<E>	next;
	public SNode(E newItem, SNode<E> node) {
		item = newItem;
		next = node;
	}
	public E			getItem() 					{return item;}
	public SNode<E>		getNext() 					{return next;}
	public void 		setItem(E newItem)		 	{item = newItem;}
	public void 		setNext(SNode<E> newNext) 	{next = newNext;}	
}
