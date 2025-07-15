package com.tnsif.dayfourteen.listDemo;

import java.util.ArrayDeque;
import java.util.Deque;

public class ExDequeDemo {

	public static void main(String[] args) {
	 
		Deque<String> deque1=new ArrayDeque<String>();
		deque1.add("Gayatri");
		deque1.add("Karan");
		deque1.add("trupti");
		deque1.add("isha");
		
		System.out.println(deque1);
		
		deque1.pollLast();
		System.out.println(deque1);
		
		deque1.pollFirst();
		System.out.println(deque1);
		
		for(String str : deque1)
		{
			System.out.println("queue is :"+ str);
		}
		
		System.out.println(deque1);
		

		
	}
}
