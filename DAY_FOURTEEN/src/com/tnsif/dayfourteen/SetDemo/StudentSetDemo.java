package com.tnsif.dayfourteen.SetDemo;

import java.util.HashSet;
import java.util.Set;

public class StudentSetDemo {

	public static void main(String[] args) {
		Set<Student>set=new HashSet<Student>();
		set.add(new Student(101,"Isha",78.78));
		set.add(new Student(102,"ashu",90.28));
		set.add(new Student(103,"tanu",65.22));
		set.add(new Student(101,"Isha",78.78));
		set.add(new Student(101,"Isha",77.78));
		System.out.println(set);
	}
}
