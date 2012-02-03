package functions;

import java.util.ArrayList;
import java.util.Map;

/*Clamp is a type of Function, which evaluates the ArrayList Expressions by using
 *the RGBColor method clamp to [-1 to 1]
*/
public class Clamp extends Function{
	public Clamp(ArrayList<Expression> list){
		super(list);
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
		
		return (type.equals("clamp"));
	}
	
	//Evaluates expression by clamping the given value to the Color's max and min values [-1 to 1].
	public RGBColor evaluate(Map <String,Expression> input) {
		
		RGBColor newColor = new RGBColor (myList.get(0).evaluate(input));
	       newColor.clamp();
	       return newColor;
	}
}