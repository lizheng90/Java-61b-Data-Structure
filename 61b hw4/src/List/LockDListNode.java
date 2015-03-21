package List;

public class LockDListNode extends DListNode{
	protected boolean isLocked;
	
	LockDListNode(Object item,DListNode n1,DListNode n2){
		super(item,n1,n2);
		isLocked=false;
	}
}
