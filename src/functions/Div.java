package functions;

import java.util.ArrayList;
import java.util.Map;

//Div is a type of Function, which evaluates the ArrayList with division
public class Div extends Function {

	public Div(ArrayList<Expression> list){
		super(list);
		myCommand = "div";
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
		return (type.equals(myCommand) || type.equals("/"));
	}
	
	// Evaluates by dividing the first expression by the second expression
	public RGBColor evaluate(Map <String,Expression> input) {
		
		return new RGBColor (myList.get(0).evaluate(input).getRed() / myList.get(1).evaluate(input).getRed(), 
                            myList.get(0).evaluate(input).getGreen() / myList.get(1).evaluate(input).getGreen(),
                            myList.get(0).evaluate(input).getBlue() / myList.get(1).evaluate(input).getBlue());
	}

}
