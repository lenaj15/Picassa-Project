package functions;

import java.util.ArrayList;
import java.util.Map;

/*Wrap is a type of Function, which evaluates the ArrayList Expressions by using
 *the RGBColor method wrap to [-1 to 1]
*/
public class Wrap extends Function{
	
	public Wrap(ArrayList<Expression> list){
		super(list);
		myCommand = "wrap";
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
		
		return (type.equals(myCommand));
	}
	
	//Evaluates expression by wrapping the given value to the Color's max and min values [-1 to 1].
	public RGBColor evaluate(Map <String,Expression> input) {
		
		RGBColor newColor = new RGBColor (myList.get(0).evaluate(input));
       newColor.wrap();
       return newColor;
	}
}
