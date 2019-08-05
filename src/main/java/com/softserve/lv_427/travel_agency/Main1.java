package com.softserve.lv_427.travel_agency;

interface SayHello{
  
} 

abstract class SaySmth implements SayHello{
    
}

class Person extends SaySmth{

    @Override
    public void hello() {
        System.out.println("Hello");
    }
}
public class Main1
{
	 public static void main(String[] args) {
		 Person p1 = new Person();
		 Person p2 = new Person();
		 p1.
	 }
}