package CSS1035SECUREBANK;

import java.util.ArrayList;
import java.util.List;

public class Generic {

	public static void main(String[] args) {

		List<Object> list1 = new ArrayList<Object>();
		list1.add("card");//new credit cards
		list1.add(new Integer(31));
		String s1 = (String) list1.get(0);
		System.out.println(list1.size());
		Integer i1 = (Integer) list1.get(0);
		Integer i2 = (Integer) list1.get(1);

		List<String> list2 = new ArrayList<String>();
		list2.add("hello");//new person
		// list2.add(new Integer(31));
		String s2 = list2.get(0); // no cast
		System.out.println(list2.size());
		String aString = list2.get(0);
	}
}