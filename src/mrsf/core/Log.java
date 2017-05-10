package mrsf.core;

import java.util.Map;

public class Log {

	public static void echo(String s){
		System.out.println(s);
	}
	
	public static void echo(Map<?, ?> s){
		System.out.println(s.toString());
	}
	
	public static void echo(Object s){
		System.out.println(s.toString());
	}
	
}
