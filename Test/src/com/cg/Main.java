package com.cg;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m=new Main();
        m.test();
        
        String s= "Sachin";
        s.concat("Tendulkar");
        System.out.println(s);

	}
	
	public void test() {
        List<Integer> list = new ArrayList<>(); 
        list.add(1);
        list.add(2);
        method(list);

        System.out.println(list.size());
}
    public void method(List li){
            li.add(3);
            li.add(4);
        }

}
