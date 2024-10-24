package com.cg;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practise {
	
	public static void main(String[] args) {
		
		
		
		String str="JavaStreamsAPI";
		//String Occurance
		Map<String, Long> occurance = Arrays.stream(str.split(""))
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	//	System.out.println(occurance);
		
		 int [] intArray= {10,20,30,40,50,40,20};
		 Map<Integer, Long> numOccurance = Arrays.stream(intArray)
		 .boxed()
		 .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		 //System.out.println(numOccurance);
		 
		 int [] intArray2= {10,20,30,40,50,40,20};
		 
		 List<Integer> duplicateEntries = Arrays.stream(intArray)
		.boxed()
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet()
		.stream()
		.filter(n->n.getValue()>1)
		.map(Map.Entry::getKey)
		.collect(Collectors.toList());
		// System.out.println(duplicateEntries);
		 
		 int [] intArray3= {10,20,30,40,50,40,20};
		 
		  List<Integer> uniqueData = Arrays.stream(intArray3)
		 .boxed()
		 .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		 .entrySet()
		 .stream()
		 .filter(n->n.getValue()==1)
		 .map(Map.Entry::getKey)
		 .collect(Collectors.toList());
		  System.out.println(uniqueData);
		  
		  
		  
	}

}
