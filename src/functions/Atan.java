package functions;

import java.util.ArrayList;
import java.util.Map;

//Atan is a type of Function, which evaluates the ArrayList with arctangent 
public class Atan extends Function{
	public Atan(ArrayList<Expression> list){
		super(list);
		myCommand = "atan";
	}
	
	// Checks if the command input matches the Expression type 
	public boolean isThisKindOfThing(String type) {
		return (type.equals(myCommand));
	}
	
	//Evaluates expression by taking the arctangent of each color component
	public RGBColor evaluate(Map <String,Expression> input) {
		return new RGBColor (Math.atan(myList.get(0).evaluate(input).getRed()), 
				Math.atan(myList.get(0).evaluate(input).getGreen()) ,
				Math.atan(myList.get(0).evaluate(input).getBlue()));
		
	}
}
