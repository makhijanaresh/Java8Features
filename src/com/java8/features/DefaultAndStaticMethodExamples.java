package com.java8.features;

interface Car
{
	
	default void properties()
	{
		System.out.println("inteface method properties invoked");
	}
	
	public static void manual()
	{
		System.out.println("Test Static method invoked");
	}
}

class Tata implements Car
{
	@Override
	public void properties()
	{
		System.out.println("My Custom property");
	}
	
	
}

public class DefaultAndStaticMethodExamples {

	
	public static void main(String[] args) {
		Tata t=new Tata();
		t.properties();
		Car.manual();
	}
}
