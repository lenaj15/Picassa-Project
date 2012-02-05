package functions;

import java.util.ArrayList;
import java.util.Map;

//Exp is a type of Function, which evaluates the ArrayList with exponents
public class Exp extends Function {

	public Exp(ArrayList<Expression> list){
		super(list);
		myCommand = "exp";
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
		return (type.equals(myCommand) || type.equals("^"));
	}
	
	// Evaluates by raising the first expression to the second expression
	public RGBColor evaluate(Map <String,Expression> input) {
		
		return new RGBColor (Math.pow(myList.get(0).evaluate(input).getRed(), myList.get(1).evaluate(input).getRed()), 
                           Math.pow(myList.get(0).evaluate(input).getGreen(), myList.get(1).evaluate(input).getGreen()),
                           Math.pow(myList.get(0).evaluate(input).getBlue(), myList.get(1).evaluate(input).getBlue()));
	}

}
