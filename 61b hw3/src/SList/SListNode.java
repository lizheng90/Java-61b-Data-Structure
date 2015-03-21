package SList;

public class SListNode {
	  Object item;
	  SListNode next;


	  /**
	   *  SListNode() (with two parameters) constructs a list node referencing the
	   *  item "obj", whose next list node is to be "next".
	   */

	  SListNode(Object obj, SListNode next) {
	    item = obj;
	    this.next = next;
	  }

	  /**
	   *  SListNode() (with one parameter) constructs a list node referencing the
	   *  item "obj".
	   */

	  SListNode(Object obj) {
	    this(obj, null);
	  }
}
