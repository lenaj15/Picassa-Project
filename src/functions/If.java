package functions;

import java.util.ArrayList;
import java.util.Map;

// This class is a subclass of Function, and evaluates the 2nd or 3rd expression
// based on the validity of the first expression
public class If extends Function{

	public If (ArrayList<Expression> exp){
		super (exp);
		myCommand = "if";
	}
	
	// Evaluates expression by first seeing if the first expression is greater than 0,
	// if it is then evaluates the second expression and if it is not, then evaluate third expression
	public RGBColor evaluate(Map<String, Expression> input) {
		RGBColor colors = myList.get(0).evaluate(input);
		if (((colors.getBlue()+ colors.getGreen()+ colors.getRed())/3) >0)
			return myList.get(1).evaluate(input);
	
		return myList.get(2).evaluate(input);
	}
		
	// Checks if the command input matches the Expression type
public boolean isThisKindOfThing(String type) {
	
		return (type.equals(myCommand));
	}

}
