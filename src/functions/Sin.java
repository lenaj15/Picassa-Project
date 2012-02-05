package functions;

import java.util.ArrayList;
import java.util.Map;

/*Sin is a type of Function, which evaluates the ArrayList Expressions taking the
 * sin of the one input expression
*/
public class Sin extends Function{
	public Sin(ArrayList<Expression> list){
		super(list);
		myCommand = "sin";
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
		return (type.equals(myCommand));
	}
	
	
	//Evaluates expression by taking the sin of each color component
	public RGBColor evaluate(Map <String,Expression> input) {
		return new RGBColor (Math.sin(myList.get(0).evaluate(input).getRed()), 
				Math.sin(myList.get(0).evaluate(input).getGreen()) ,
				Math.sin(myList.get(0).evaluate(input).getBlue()));
		
	}
}
