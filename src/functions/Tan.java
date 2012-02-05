package functions;

import java.util.ArrayList;
import java.util.Map;

/*Tan is a type of Function which evaluates the ArrayList Expressions taking the
 * tangent of the one input expression
*/
public class Tan extends Function{
	public Tan(ArrayList<Expression> list){
		super(list);
		myCommand = "tan";
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
		return (type.equals(myCommand));
	}
	
	//Evaluates expression by taking the tangent of each color component
	public RGBColor evaluate(Map <String,Expression> input) {
		return new RGBColor (Math.tan(myList.get(0).evaluate(input).getRed()), 
				Math.tan(myList.get(0).evaluate(input).getGreen()) ,
				Math.tan(myList.get(0).evaluate(input).getBlue()));
		
	}
}

