package functions;

import java.util.ArrayList;
import java.util.Map;

/*Neg is a type of Function, which evaluates the ArrayList Expressions through negation
*/
public class Neg extends Function{
	public Neg(ArrayList<Expression> list){
		super(list);
		myCommand = "neg";
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
		return (type.equals(myCommand) || type.equals("!"));
	}
	
	//Evaluates expression by negating each color component
	public RGBColor evaluate(Map <String,Expression> input) {
		
		return new RGBColor (myList.get(0).evaluate(input).getRed() , 
                -myList.get(0).evaluate(input).getGreen() ,
                -myList.get(0).evaluate(input).getBlue());
		
		
	}
}
