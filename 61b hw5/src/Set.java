/* Set.java */

import list.*;

/**
 *  A Set is a collection of Comparable elements stored in sorted order.
 *  Duplicate elements are not permitted in a Set.
 **/
public class Set {
  /* Fill in the data fields here. */
	private DList list;

  /**
   * Set ADT invariants:
   *  1)  The Set's elements must be precisely the elements of the List.
   *  2)  The List must always contain Comparable elements, and those elements 
   *      must always be sorted in ascending order.
   *  3)  No two elements in the List may be equal according to compareTo().
   **/

  /**
   *  Constructs an empty Set. 
   *
   *  Performance:  runs in O(1) time.
   **/
  public Set() { 
    // Your solution here.
	  list = new DList();
  }

  /**
   *  cardinality() returns the number of elements in this Set.
   *
   *  Performance:  runs in O(1) time.
   **/
  public int cardinality() {
    // Replace the following line with your solution.
	  return list.length();
  }

  /**
   *  insert() inserts a Comparable element into this Set.
   *
   *  Sets are maintained in sorted order.  The ordering is specified by the
   *  compareTo() method of the java.lang.Comparable interface.
   *
   *  Performance:  runs in O(this.cardinality()) time.
   **/
  public void insert(Comparable c) {
    // Your solution here.
	  if(list.isEmpty()){
		  list.insertFront(c);
	  }
	  else{
		  ListNode curr = list.front();
		  try{
			  while(c.compareTo(curr.item())!=0){
				  if(c.compareTo(curr.item())<0){
					  curr.insertBefore(c);
					  return;
				  }
				  curr=curr.next();
				  if(!curr.isValidNode()){
					  list.insertBack(c);
					  return;
				  }
			  }
		  }
		  catch(InvalidNodeException e){}
	  }
  }

  /**
   *  union() modifies this Set so that it contains all the elements it
   *  started with, plus all the elements of s.  The Set s is NOT modified.
   *  Make sure that duplicate elements are not created.
   *
   *  Performance:  Must run in O(this.cardinality() + s.cardinality()) time.
   *
   *  Your implementation should NOT copy elements of s or "this", though it
   *  will copy _references_ to the elements of s.  Your implementation will
   *  create new _nodes_ for the elements of s that are added to "this", but
   *  you should reuse the nodes that are already part of "this".
   *
   *  DO NOT MODIFY THE SET s.
   *  DO NOT ATTEMPT TO COPY ELEMENTS; just copy _references_ to them.
   **/
  public void union(Set s) {
    // Your solution here.
//	  if(list.isEmpty()&&s.list.isEmpty())
//		  return;
//	  ListNode curr = 
//	  try{
//		  ListNode l1 = list.front();
//		  ListNode l2 = s.list.front();
//		  while(l1.isValidNode()&&l2.isValidNode()){
//			  if(((Comparable)l1.item()).compareTo(l2.item())>0){
//				  l1.insertBefore(l2.item());
//				  l2=l2.next();
//			  }
//			  else{
//				  l1=l1.next();
//			  }
//		  }
//		  list.insertBack(l2.item());
//	  }
//	  catch(InvalidNodeException g){}
	  try{
		  ListNode n1 = list.front();
		  ListNode n2 = s.list.front();
		  while(n2.isValidNode()){//终止条件看n2
			  if(((Comparable)n1.item()).compareTo(n2.item())>0){
				  n1.insertBefore(n2.item());
				  n2=n2.next();
			  }
			  else if (((Comparable)n1.item()).compareTo(n2.item())==0){
				  if(n1.next().isValidNode()){//保证n1 if可比
					  n1=n1.next();
				  }
				  n2=n2.next();
			  }
			  else{
//				  if(n2.prev().isValidNode())//???
//					  if(((Comparable)n1.next().item()).compareTo(n2.item())>0)
//						  n1.next().insertBefore(n2);
					  
				  if(n1.equals(list.back())){//n1在末尾，union所有n2
					  n1.insertAfter(n2.item());
					  n2=n2.next();
				  }
				  if(n1.next().isValidNode())
					  n1=n1.next();
//				  if(!n1.next().isValidNode()&&!n2.next().isValidNode()){
//					  list.insertBack(n2.item());//比较最后一位
//					  break;
//				  }
			  }
//			  else{
//				  if(n1.next().isValidNode())
//					  n1=n1.next();
//				  if(!n1.next().isValidNode()&&!n2.next().isValidNode()){
//					  list.insertBack(n2.item());//比较最后一位
//					  break;
//				  }
//			  }
//			  if(!n1.next().isValidNode()&&n2.next().isValidNode()){//让n2总能到末尾
//				  n2=n2.next();
//			  }
		  }
//		  if(!n2.next().isValidNode()){//两list末尾没比较就跳出了
//			  list.insertBack(n2.item());
//		  }
	  }
	  catch(InvalidNodeException g){}
  }

  /**
   *  intersect() modifies this Set so that it contains the intersection of
   *  its own elements and the elements of s.  The Set s is NOT modified.
   *
   *  Performance:  Must run in O(this.cardinality() + s.cardinality()) time.
   *
   *  Do not construct any new ListNodes during the execution of intersect.
   *  Reuse the nodes of "this" that will be in the intersection.
   *
   *  DO NOT MODIFY THE SET s.
   *  DO NOT CONSTRUCT ANY NEW NODES.
   *  DO NOT ATTEMPT TO COPY ELEMENTS.
   **/
  public void intersect(Set s) {
    // Your solution here.
	  try{
		  ListNode n1 = list.front();
		  ListNode n2 = s.list.front();
		  while(n1.isValidNode()){//不能设n1 n2 都valid因为如果n2结束，n1未结束，n1后面没删掉
			  if(((Comparable)n1.item()).compareTo(n2.item())>0){
				  if(n2.equals(s.list.back())){//n2在末尾，n1删掉当前及以后所有的，因为均>n2
					  ListNode n3 = n1.next();
					  n1.remove();
					  n1=n3;
//					  n1=n1.next();
//					  n1.prev().remove();
				  }
				  if(n2.next().isValidNode()){//保证n2有效，下一次if
					  n2=n2.next();
				  }
			  }
			  else if(((Comparable)n1.item()).compareTo(n2.item())<0){
				  ListNode n3 = n1.next();
				  n1.remove();
				  n1=n3;
//				  n1=n1.next();//这n1 next 为 null 时候有问题啊， because null.prev不一定是n1！！！
//				  n1.prev().remove();
			  }
			  else{
				  n1=n1.next();
				  if(n2.next().isValidNode()){//保证n2有效，下一次if
					  n2=n2.next();
				  }
			  }
		  }
	  }
	  catch(InvalidNodeException h){}
  }

  /**
   *  toString() returns a String representation of this Set.  The String must
   *  have the following format:
   *    {  } for an empty Set.  No spaces before "{" or after "}"; two spaces
   *            between them.
   *    {  1  2  3  } for a Set of three Integer elements.  No spaces before
   *            "{" or after "}"; two spaces before and after each element.
   *            Elements are printed with their own toString method, whatever
   *            that may be.  The elements must appear in sorted order, from
   *            lowest to highest according to the compareTo() method.
   *
   *  WARNING:  THE AUTOGRADER EXPECTS YOU TO PRINT SETS IN _EXACTLY_ THIS
   *            FORMAT, RIGHT UP TO THE TWO SPACES BETWEEN ELEMENTS.  ANY
   *            DEVIATIONS WILL LOSE POINTS.
   **/
  public String toString() {
    // Replace the following line with your solution.
	  String result ="{ ";
	  try{
		  ListNode curr = list.front();
		  while(curr.isValidNode()){
			  result = result+curr.item()+" ";
			  curr=curr.next();
		  }
	  }
	  catch(InvalidNodeException f){}
	  return result+"}";
  }

  public static void main(String[] argv) {
    Set s = new Set();
    s.insert(new Integer(3));
    s.insert(new Integer(6));
    s.insert(new Integer(3));
    System.out.println("Set s = " + s);

    Set s2 = new Set();
    s2.insert(new Integer(4));
    s2.insert(new Integer(5));
    s2.insert(new Integer(5));
    System.out.println("Set s2 = " + s2);

    Set s3 = new Set();
    s3.insert(new Integer(5));
    s3.insert(new Integer(3));
    s3.insert(new Integer(8));
    System.out.println("Set s3 = " + s3);

    s.union(s2);
    System.out.println("After s.union(s2), s = " + s);

    s.intersect(s3);
    System.out.println("After s.intersect(s3), s = " + s);

    System.out.println("s.cardinality() = " + s.cardinality());
    // You may want to add more (ungraded) test code here.
  }
}