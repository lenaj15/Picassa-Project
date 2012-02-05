package functions;

import java.util.ArrayList;
import java.util.Map;

//This class evaluates the expression using a variable that the user sets
public class Let extends Function{
	
	public Let (ArrayList<Expression> exp){
		super (exp);
		myCommand = "let";
	}
	
	@Override
	
	//1st element in myList will be the variable
	// Evaluates based on that first element variable
	public RGBColor evaluate(Map<String, Expression> input) {
		
		input.putAll(((Variable) myList.get(0)).getMap()); 
		
		return myList.get(1).evaluate(input);
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
	
		return (type.equals(myCommand));
	}

	
}
