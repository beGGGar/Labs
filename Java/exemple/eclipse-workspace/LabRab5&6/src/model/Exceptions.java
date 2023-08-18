package model;

public class Exceptions {

	static class StringException extends Exception{
		 
	    private String name;
	    public String getName(){return name;}
	    public StringException(String message, String str){
	     
	        super(message);
	        name=str;
	    }
	}
	
	static class NumberException extends Exception{
		 
	    private float num;
	    public float getName(){return num;}
	    public NumberException(String message, float number){
	     
	        super(message);
	        num = number;
	    }
	}
	
	
}
