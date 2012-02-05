package functions;

import java.util.ArrayList;
import java.util.Map;

import model.ParserException;
import model.ParserException.Type;
/*Random is a type of Function that creates a random color, and takes no input
*/
public class Random extends Function{
	public Random(ArrayList<Expression> list){
		super(list);
		myList = null;
		myCommand = "random";
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
		
		return (type.equals(myCommand));
	}
	
	//Evaluates expression by creating a random color
	public RGBColor evaluate(Map <String,Expression> input) {
		
		return new RGBColor (Math.random());
       
	}
}