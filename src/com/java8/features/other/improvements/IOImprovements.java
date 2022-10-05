package com.java8.features.other.improvements;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class IOImprovements {

	
	public static void main(String[] args) {
		try
		{
			//prints line by line
			//Files.lines(Path.of("D:\\ImpData\\employee.yam")).forEach(System.out::println);
			//Files.list(new File("D:\\ImpData\\").toPath()).forEach(System.out::println);
			
			Files.list(new File("D:\\ImpData\\").toPath())
			.filter(p->p.getFileName().toString().startsWith("Re")).limit(2).forEach(System.err::println);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
