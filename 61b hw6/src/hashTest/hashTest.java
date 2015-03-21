package hashTest;
import java.util.*;
public class hashTest {
	public static void main(String[] args){
//		Hashtable<Integer, String> table = new Hashtable<Integer, String>();
//		table.put(1, "1");
//		table.put(2, "2");
//		for(int i=0;i<table.size();i++){
//			System.out.println(table.get(1));
//		
//		}
//		HashMap<Integer, String> map = new HashMap<Integer, String>();
//		  map.put(1, "2");
//		  map.put(2, "3");
//		  map.put(null,null);      //HashMap 允许null值，但key只能有一个null，否则后面不会被保存，
//		  for(int i=0;i<map.size();i++){
//		   System.out.println(map.get(1));
//		  }
		HashSet<Integer> s = new HashSet<Integer>();
		  s.add(Integer.valueOf(1));
		  s.add(Integer.valueOf(1));
		  for(Integer i:s){
		   System.out.println(i);
		  }
	}
}
