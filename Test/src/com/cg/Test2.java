package com.cg;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test2 {
	
	public static void main(String[] args) {
		
		String str="JavaStreamsAPI";
		
		Map<String, Long> charOccurance = Arrays.stream(str.split(""))
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		//System.out.println(charOccurance);
		
		  int [] intArray= {10,20,30,40,50,40,20};
		  Map<Integer, Long> numOccurance = Arrays.stream(intArray)
		  .boxed()
		  .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		 // System.out.println(numOccurance);
		  
		  String str2="JavJa";
		  
		  List<String> duplicateCList = Arrays.stream(str2.split(""))
		  .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		  
		  .entrySet()
		  .stream()
		  .filter(n->n.getValue()>1)
		  .map(Map.Entry::getKey).
		  collect(Collectors.toList());
		//  System.out.println(duplicateCList);
		  
		  
		  String str3="Java";
		  List<String> collect = Arrays.stream(str3.split(""))
		  .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		  .entrySet()
		  .stream()
		  .filter(n->n.getValue()==1)
		  .map(Map.Entry::getKey)
		  .collect(Collectors.toList());
		//  System.out.println(collect);
		
		  
		  String str4="Java";
		  
		  String NonRepeatedChars = Arrays.stream(str3.split(""))
		  .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new
				  ,Collectors.counting()))
		  .entrySet()
		  .stream()
		  .filter(n->n.getValue()==1)
		  .map(Map.Entry::getKey)
		  .findFirst()
		  .get();
	     
		//  System.out.println(NonRepeatedChars);
		  
		  
		  int[] intArray3= {1,3,5,11,21,14};
		  Integer integer = Arrays.stream(intArray3)
		  .boxed()
		  .sorted(Comparator.reverseOrder())
		  .skip(1)
		  .findFirst()
		  .get();
		  //System.out.println(integer);
				  
		  
		  String[] strArray= {"Java","SpringBootq","Microservi","Shrirampur111"};
		String longestString = Arrays.stream(strArray)
		.reduce((s1,s2)->s1.length()>s2.length()?s1:s2).get();
	//	System.out.println(longestString);
		
		 int[] intArray4= {10,20,30,40,50};
		 Integer sum = Arrays.stream(intArray4).boxed()
		 .reduce((I1,I2)->I1+I2).get();
		// System.out.println(sum);
		 
		 
		 Map<String,Integer> map=new HashMap<>();
		    map.put("JOHN", 4000);
		    map.put("Williams", 5000);
		    map.put("Smith", 1000);
		    map.put("Clark", 3500);
		   
		    Entry<String, Integer> entry = map.entrySet()
		    .stream()
		    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
		    .collect(Collectors.toList()).get(1);
		     // System.out.println(entry);
		      Entry<String, Integer> entry2 = map.entrySet()
		  		    .stream()
		  		    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
		  		    .skip(1)
		  		    .findFirst()
		  		    .get();
		  		    
		  		      System.out.println(entry2);
		    
		    
		    		
		    		
		    		
		    		
		  
		 
		
		
		
		
	
		

		  

		  
		  

		  
		  
		  
		  


		
		

		
        
		
		
	}

}
