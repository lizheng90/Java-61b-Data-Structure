package list;


public class SList {


		  private SListNode head;
		  private int size;

		  /**
		   *  SList() constructs an empty list.
		   **/

		  public SList() {
		    size = 0;
		    head = null;
		  }

		  /**
		   *  isEmpty() indicates whether the list is empty.
		   *  @return true if the list is empty, false otherwise.
		   **/

		  public boolean isEmpty() {
		    return size == 0;
		  }

		  /**
		   *  length() returns the length of this list.
		   *  @return the length of this list.
		   **/

		  public int length() {
		    return size;
		  }

		  /**
		   *  insertFront() inserts item "obj" at the beginning of this list.
		   *  @param obj the item to be inserted.
		   **/

		  public void insertFront(Object obj) {
		    head = new SListNode(obj, head);
		    size++;
		  }

		  /**
		   *  insertEnd() inserts item "obj" at the end of this list.
		   *  @param obj the item to be inserted.
		   **/

		  public void insertEnd(Object obj) {
		    if (head == null) {
		      head = new SListNode(obj);
		    } else {
		      SListNode node = head;
		      while (node.next != null) {
		        node = node.next;
		      }
		      node.next = new SListNode(obj);
		    }
		    size++;
		  }

		  /**
		   *  nth() returns the item at the specified position.  If position < 1 or
		   *  position > this.length(), null is returned.  Otherwise, the item at
		   *  position "position" is returned.  The list does not change.
		   *  @param position the desired position, from 1 to length(), in the list.
		   *  @return the item at the given position in the list.
		   **/

		  public Object nth(int position) {//深入理解！！！
		    SListNode currentNode;

		    if ((position < 1) || (head == null)) {
		      return null;
		    } else {
		      currentNode = head;
		      while (position > 1) {
		        currentNode = currentNode.next;
		        if (currentNode == null) {
		          return null;
		        }
		        position--;
		      }
		      return currentNode.item;
		    }
		  }
		  //加入remove//深入理解！！！
		  public void remove(int position) {
			    SListNode currentNode;
			    if (head == null) { //low bound
			      return;
			    }
			    if (position == 0) {
			    	head = head.next;
			    } else {
			      currentNode = head;
			      while (position > 1) {
			        currentNode = currentNode.next;
			        if (currentNode == null) {//upper bound
			          return;
			        }
			        position--;
			      }
			      currentNode.next = currentNode.next.next;
			    }
			    size--;
			  }
		  /**
		   *  squish() takes this list and, wherever two or more consecutive items are
		   *  equals(), it removes duplicate nodes so that only one consecutive copy
		   *  remains.  Hence, no two consecutive items in this list are equals() upon
		   *  completion of the procedure.
		   *
		   *  After squish() executes, the list may well be shorter than when squish()
		   *  began.  No extra items are added to make up for those removed.
		   *
		   *  For example, if the input list is [ 0 0 0 0 1 1 0 0 0 3 3 3 1 1 0 ], the
		   *  output list is [ 0 1 0 3 1 0 ].
		   *
		   *  IMPORTANT:  Be sure you use the equals() method, and not the "=="
		   *  operator, to compare items.
		   **/

		  public void squish() {
		    // Fill in your solution here.  (Ours is eleven lines long.)
			  SListNode prev = this.head;
			  SListNode cur = this.head;
			  if (this.head == null)
				  return;
			  //这行很tricky，双指针
			  while(cur.next!=null){
				  cur = cur.next;
				  if(prev.item.equals(cur.item)){
					  prev.next = cur.next;
					  this.size--;
				  }
				  else
					  prev = prev.next;
			  }
//			  int count=0;
//			  SListNode fast = head.next;
//			  while(fast!=null){
//				  count++;
//				  fast=fast.next;
//			  }
//			  fast=head.next;
//
//			  for(int i=1;i<count;i++){
//				  if(fast.item.equals(fast.next.item)){
//					  fast=fast.next;
//				  }
//				  else{
//					  insertEnd(fast.item);
//				  }
//			  }
//			  if(!fast.item.equals(fast.next.item)){
//				  insertEnd(fast.next.item);
//			  }
//			  
			  cur = this.head;
			  while(cur!=null){
				  System.out.print(cur.item +" ");
				  cur = cur.next;
			  }
			  System.out.println();
			  System.out.println(this.size);
		  }

		  /**
		   *  twin() takes this list and doubles its length by replacing each node
		   *  with two consecutive nodes referencing the same item.
		   *
		   *  For example, if the input list is [ 3 7 4 2 2 ], the
		   *  output list is [ 3 3 7 7 4 4 2 2 2 2 ].
		   *
		   *  IMPORTANT:  Do not try to make new copies of the items themselves.
		   *  Make new SListNodes, but just copy the references to the items.
		   **/

		  public void twin() {
		    // Fill in your solution here.  (Ours is seven lines long.)
			  SListNode curr = head;
			  if(head==null)
				  return;
			  while(curr!=null){
				  SListNode tmp = new SListNode(curr.item,curr.next);
				  curr.next=tmp;
				  curr=curr.next.next;
				  this.size++;
			  }
			  
			  curr = this.head;
			  while(curr!=null){
				  System.out.print(curr.item +" ");
				  curr = curr.next;
			  }
			  System.out.println();
			  System.out.println(this.size);
//			  for(int i=0;i<this.length()-1;i++){
//				  SListNode s = new SListNode(curr.next.item,curr.next.next);
//				  curr.next.next = s;
//				  curr = curr.next.next;
//			  }
//			  curr = head.next;
//			  for(int i=0;i<this.size*2-2;i++){
//				  System.out.print(curr.item + " ");
//			  } 
		  }

		  /**
		   *  toString() converts the list to a String.
		   *  @return a String representation of the list.
		   **/

//		  public String toString() {
//		    int i;
//		    Object obj;
//		    String result = "[  ";
//
//		    SListNode cur = head;
//
//		    while (cur != null) {
//		      obj = cur.item;
//		      result = result + obj.toString() + "  ";
//		      cur = cur.next;
//		    }
//		    result = result + "]";
//		    return result;
//		  }
		  
		  public static void main(String[] args){
			  SList x = new SList();
			  x.insertEnd(3);
			  x.insertEnd(3);
			  x.insertEnd(2);
			  x.insertEnd(4);
			  x.squish();
//			  x.twin();
		  }
}

	
