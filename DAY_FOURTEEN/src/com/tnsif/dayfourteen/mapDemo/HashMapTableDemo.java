package com.tnsif.dayfourteen.mapDemo;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Set;

public class HashMapTableDemo {
	public static void main(String[] args) {
		
		Hashtable<Integer,String> ht=new Hashtable<Integer,String>();
		ht.put(101, "Mumbai");
		ht.put(102, " Navi Mumbai");
		ht.put(103, "pune");
		ht.put(105, "Mumbai");
		ht.put(104, "Jalgaon");
		ht.put(101, "Jalgaon");
		
		System.out.println(ht);
		ht.putIfAbsent(105, "PCMC");
		ht.put(101, "Baramati");
		
		System.out.println(ht);
		
		//ht.put(null, "shcvhj");
		System.out.println(ht);
		
		System.out.println(ht.get(103));
		
		System.out.println(ht.replace(102, "Bombay"));
		System.out.println(ht);
		
		ht.clone();
		System.out.println(ht);
		
		Set s=ht.keySet();
		System.out.println(s);
		Collection<String> c=ht.values();
		System.out.println(c);
		
		
		

	
	}

}
