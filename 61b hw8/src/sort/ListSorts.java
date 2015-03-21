package sort;

/* ListSorts.java */

import list.*;

public class ListSorts {

  private final static int SORTSIZE = 1000;

  /**
   *  makeQueueOfQueues() makes a queue of queues, each containing one item
   *  of q.  Upon completion of this method, q is empty.
   *  @param q is a LinkedQueue of objects.
   *  @return a LinkedQueue containing LinkedQueue objects, each of which
   *    contains one object from q.
   **/
  public static LinkedQueue makeQueueOfQueues(LinkedQueue q) {
    // Replace the following line with your solution.
	  LinkedQueue result = new LinkedQueue();
	  while(!q.isEmpty()){//这里如果用q.size()不行，因为size是变化的
		  LinkedQueue qtmp = new LinkedQueue();
		  try{
			  qtmp.enqueue(q.front());
			  q.dequeue();
			  result.enqueue(qtmp);
		  }
		  catch(QueueEmptyException e) {}
	  }
	  return result;
  }

  /**
   *  mergeSortedQueues() merges two sorted queues into a third.  On completion
   *  of this method, q1 and q2 are empty, and their items have been merged
   *  into the returned queue.
   *  @param q1 is LinkedQueue of Comparable objects, sorted from smallest 
   *    to largest.
   *  @param q2 is LinkedQueue of Comparable objects, sorted from smallest 
   *    to largest.
   *  @return a LinkedQueue containing all the Comparable objects from q1 
   *   and q2 (and nothing else), sorted from smallest to largest.
   **/
  public static LinkedQueue mergeSortedQueues(LinkedQueue q1, LinkedQueue q2) {
    // Replace the following line with your solution.
    LinkedQueue q = new LinkedQueue();    
    while(!q1.isEmpty() && !q2.isEmpty()){
    	try{
    		if(((Comparable)q1.front()).compareTo((Comparable)q2.front()) < 0){
    			q.enqueue(q1.dequeue());
        	}
    		else{
    			q.enqueue(q2.dequeue());
    		}
    	}
    	catch(QueueEmptyException e) {}
    }
    if(!q1.isEmpty()){
    	q.append(q1);
    }
    else{
    	q.append(q2);
    }
    return q;
  }

  /**
   *  partition() partitions qIn using the pivot item.  On completion of
   *  this method, qIn is empty, and its items have been moved to qSmall,
   *  qEquals, and qLarge, according to their relationship to the pivot.
   *  @param qIn is a LinkedQueue of Comparable objects.
   *  @param pivot is a Comparable item used for partitioning.
   *  @param qSmall is a LinkedQueue, in which all items less than pivot
   *    will be enqueued.
   *  @param qEquals is a LinkedQueue, in which all items equal to the pivot
   *    will be enqueued.
   *  @param qLarge is a LinkedQueue, in which all items greater than pivot
   *    will be enqueued.  
   **/   
  public static void partition(LinkedQueue qIn, Comparable pivot, 
                               LinkedQueue qSmall, LinkedQueue qEquals, 
                               LinkedQueue qLarge) {
    // Your solution here.
	  if(qIn.isEmpty())
		  return;
	  try{
		  while(!qIn.isEmpty()){
			  Object o = qIn.dequeue();
			  if(((Comparable)o).compareTo(pivot) < 0){
				  qSmall.enqueue(o);
			  }
			  else if(((Comparable)o).compareTo(pivot) == 0){
				  qEquals.enqueue(o);
			  }
			  else{
				  qLarge.enqueue(o);
			  }
		  }
	  }
	  catch(QueueEmptyException e) {}
  }

  /**
   *  mergeSort() sorts q from smallest to largest using mergesort.
   *  @param q is a LinkedQueue of Comparable objects.
   **/
  public static void mergeSort(LinkedQueue q) {
    // Your solution here.
//	  if(q.size()==0 || q.size()==1){
//		  return q;
//	  }
//	  LinkedQueue q1 = new LinkedQueue();
//	  LinkedQueue q2 = new LinkedQueue();
//	  int half = q.size()/2;
//	  try{
//		  for(int i=0;i<half;i++){
//			  q1.enqueue(q.dequeue());
//		  }
//		  for(int i=half;i<q.size()-half;i++){
//			  q2.enqueue(q.dequeue());
//		  }
//	  }
//  	  catch(QueueEmptyException e) {}
//	  q1 = mergeSort(q1);
//	  q2 = mergeSort(q2);
//	  return mergeSortedQueues(q1, q2);
	  if (q.isEmpty())
		  return;
	  LinkedQueue result = makeQueueOfQueues(q);
	  try{
		  while(result.size()>1){
			  LinkedQueue q1 = (LinkedQueue)result.dequeue();
//			  System.out.println(q1);
			  LinkedQueue q2 = (LinkedQueue)result.dequeue();
			  result.enqueue(mergeSortedQueues(q1,q2));
		  }
		  q.append((LinkedQueue)result.dequeue());
	  }
	  catch(QueueEmptyException e) {}
  }

  /**
   *  quickSort() sorts q from smallest to largest using quicksort.
   *  @param q is a LinkedQueue of Comparable objects.
   **/
  public static void quickSort(LinkedQueue q) {
    // Your solution here.
	  if (q.isEmpty()){
	        return;
	    }
	      int index = (int) (q.size() * Math.random()) + 1;
//	      System.out.println(index);
//	      System.out.println(q.size());
	      Comparable pivot = (Comparable)q.nth(index);
	      LinkedQueue qSmall = new LinkedQueue();
	      LinkedQueue qEquals = new LinkedQueue();
	      LinkedQueue qLarge = new LinkedQueue();
	      partition(q,pivot, qSmall, qEquals, qLarge);
	      quickSort(qSmall);
	      quickSort(qLarge);
	      q.append(qSmall); 
	      q.append(qEquals);
	      q.append(qLarge);
  }

  /**
   *  makeRandom() builds a LinkedQueue of the indicated size containing
   *  Integer items.  The items are randomly chosen between 0 and size - 1.
   *  @param size is the size of the resulting LinkedQueue.
   **/
  public static LinkedQueue makeRandom(int size) {
    LinkedQueue q = new LinkedQueue();
    for (int i = 0; i < size; i++) {
      q.enqueue(new Integer((int) (size * Math.random())));
    }
    return q;
  }

  /**
   *  main() performs some tests on mergesort and quicksort.  Feel free to add
   *  more tests of your own to make sure your algorithms works on boundary
   *  cases.  Your test code will not be graded.
   **/
  public static void main(String [] args) {
	
//	LinkedQueue q1 = new LinkedQueue();
//	q1.enqueue(1);
//	LinkedQueue q2 = new LinkedQueue();
//	q2.enqueue(2);
//	try{
//		System.out.println(q1.front());
//	}
//	catch(QueueEmptyException e) {}
//	LinkedQueue q3 = mergeSortedQueues(q1,q2);
//	System.out.println(q3);
    LinkedQueue q = makeRandom(10);
    System.out.println(q.toString());
    mergeSort(q);
    System.out.println(q.toString());

    q = makeRandom(10);
    System.out.println(q.toString());
    quickSort(q);
    System.out.println(q.toString());

    Timer stopWatch = new Timer();
    q = makeRandom(SORTSIZE);
    stopWatch.start();
    mergeSort(q);
    stopWatch.stop();
    System.out.println("Mergesort time, " + SORTSIZE + " Integers:  " +
                       stopWatch.elapsed() + " msec.");

    stopWatch.reset();
    q = makeRandom(SORTSIZE);
    stopWatch.start();
    quickSort(q);
    stopWatch.stop();
    System.out.println("Quicksort time, " + SORTSIZE + " Integers:  " +
                       stopWatch.elapsed() + " msec.");
    
  }

}
