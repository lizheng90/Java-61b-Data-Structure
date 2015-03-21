package List;

public class LockDList extends DList{
	
	protected LockDListNode newNode(Object item,DListNode prev, DListNode next){
		return new LockDListNode(item,prev,next);
	}
	
	public void lockNode(DListNode node){//输入均为DListNode
		((LockDListNode)node).isLocked=true;
	}
	
	public void remove(DListNode node){//输入均为DListNode
		if(((LockDListNode)node).isLocked==false)
			super.remove(node);
	}
	
	public static void main(String[] args){
		LockDList D = new LockDList();
		D.insertFront(1);
		D.insertFront(3);
		D.insertFront(6);
		D.insertFront(7);
		System.out.println(D);
		
//		LockDListNode curr = (LockDListNode)D.front();
//		curr = (LockDListNode)D.next(curr);
//		curr = (LockDListNode)D.next(curr);
//		D.remove(curr);
		
		D.lockNode(D.head.next);
		D.remove(D.head.next);
		System.out.println(D);

	}
}
