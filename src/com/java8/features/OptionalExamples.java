package com.java8.features;

import java.util.Optional;

public class OptionalExamples {

	public static void main(String[] args) {
		String str=null;
		
		Optional<String> optionalString=Optional.ofNullable("");
		if(optionalString.isPresent())
		{
			str=optionalString.get();
			System.out.println("Value is:"+str);
		}
		else
		{
			System.out.println("Nothing");
		}
		String abc="something";
		abc=Optional.ofNullable(abc).orElse(" ");
		System.out.println("ABC value is:"+abc);
		
		
		
		
	}
}
