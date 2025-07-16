package com.tnsif.dayfourteen.SetDemo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class setDemo {
	
			public static void main(String[] args) {
				Set<Integer> set=new HashSet<Integer> ();
				set.add(100);
				set.add(10);
				set.add(20);
				set.add(60);
				set.add(80);
				set.add(35);
				
				System.out.println(set);
				boolean b= set.contains(20);
				System.out.println(b);
				
				boolean b2 = set.isEmpty();
				System.out.println(b2);
				
				set.remove(20);
				System.out.println(set);
				
				Iterator<Integer> i=set.iterator();
				while(i.hasNext() )
				{
					System.out.println(i.next()+ " ");
				}
				
				
			}
		}

	

