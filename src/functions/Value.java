package functions;

import java.util.Map;

/*Value is a type of expression, which only stores a RGBColor value
*/
public class Value implements Expression{

	private RGBColor myValue;
	
	//Creates a value object with the given RGBcolor
	public Value (RGBColor value){
		myValue = value;
	}
	
	//Creates a value object with the given double value
	public Value (double val){
		myValue = new RGBColor (val);
	}
	
	//Returns the stored RGBcolor value
	public RGBColor evaluate(Map<String, Expression> myMap) {
		return myValue;
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
	
		return (type.equals("value"));
	}
	
	// Returns a string of the value object
	 public String toString ()
	    {
	        StringBuffer result = new StringBuffer();
	        return result.append(myValue).toString(); 
	    }
}
