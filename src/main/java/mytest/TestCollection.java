package mytest;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestCollection {

	public static void main(String[] args) {

		List<Object> test = new LinkedList<>();
		
		
		test.add("Hello");
		test.add(1200);
		test.add(1200.63f);
		
		
		Iterator<Object> iterator = test.listIterator();
		
		for(int i = 0; i < test.size() ; i++) {
			System.out.println("Element " + i  + " = " + test.get(i));		
		}
		
		System.out.println("-----------------------------------------------");
		
		while(iterator.hasNext()) {
			System.out.println("Element " + iterator.next());
			
		}
		
		
		Hashtable<Object, Object> ht = new Hashtable<>();
		
		ht.put("rf", "hello");
		ht.put(27, "hello");
		ht.put( new String [10], "hello");
		
		
	}

}
