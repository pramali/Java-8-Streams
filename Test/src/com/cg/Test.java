package com.cg;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
	
	public static void main(String[] args) {
		
		int [] intArray= {10,1,44,77,44,14,11};
		
		
		Set set=new HashSet();
	//	 Arrays.asList(10,1,44,77,44,14,11)
	//	Arrays.stream(intArray)
	//   .boxed().collect(Collectors.toList())
	//   .stream()
	//   .filter(n-> !set.add(n))
	 //  .forEach(System.out::println);
	//    System.out.println("done");
	    
	/*
	 * String input="JavaJava"; input.chars() .mapToObj(c->(char)c)
	 * .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
	 * .entrySet().forEach(System.out::print);;
	 */
	    
	    
	    String str4="Java";
	    //List<String> nonRepeatedCharacters = Arrays.stream(str4.split(""))
	     String nonRepeatedCharacters = Arrays.stream(str4.split(""))
	    .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
	    .entrySet()
	    .stream()
	    .filter(n->n.getValue()==1)
	    .map(Map.Entry::getKey).findFirst().get();
	  //  .collect(Collectors.toList());
	    //System.out.println(nonRepeatedCharacters);
	    
        int[] intArray3= {1,3,5,11,21,14};
      Integer secondHighest=  Arrays.stream(intArray3)
        .boxed()
        .sorted(Comparator.reverseOrder())
        .skip(1)
        .findFirst().get();
    //  System.out.println(secondHighest);
        
      
      List<String> asList = Arrays.asList("Java","Spring","Hibernate");
  String longestString=asList.stream().reduce((word1,word2)->word1.length()>word2.length()?word1:word2).get();
 
 // System.out.println(longestString);
  
  
  int[] intArray4= {10,20,30,40,50};
  Integer sum = Arrays.stream(intArray4).boxed()
  .reduce((num1,num2)->num1+num2).get();
 // System.out.println(sum);

  Map<String,Integer> map=new HashMap<>();
  map.put("JOHN", 4000);
  map.put("Williams", 5000);
  map.put("Smith", 1000);
  map.put("Clark", 3500);
  
  Entry<String, Integer> entry = map.entrySet()
 .stream()
 .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
 .skip(1).findFirst().get();
  System.out.println(entry);
  
   List<Integer> asList2 = Arrays.asList(50,40,30,35,15);
  
  Comparator<Integer> c=(I1,I2)->I1>I2?1:I1<I2?-1:0;
  
 
		  
	
 
		  
      
      
        

	    
	    
	    
        
	    
	   
	    
	    
	   
	    
		
		
		
		
	}

}
