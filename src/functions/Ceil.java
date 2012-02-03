package functions;

import java.util.ArrayList;
import java.util.Map;

/*Ceil is a type of Function, which evaluates the ArrayList Expressions by taking
the ceiling (return smallest double value that is equal to an integer and 
not less than the argument
*/
public class Ceil extends Function{
	public Ceil(ArrayList<Expression> list){
		super(list);
	}
	
	// Checks if the command input matches the Expression type 
	public boolean isThisKindOfThing(String type) {
		return (type.equals("ceil"));
	}

	//Evaluates expression by taking the ceiling of each color component
	public RGBColor evaluate(Map <String,Expression> input) {
		return new RGBColor (Math.ceil(myList.get(0).evaluate(input).getRed()), 
				Math.ceil(myList.get(0).evaluate(input).getGreen()) ,
				Math.ceil(myList.get(0).evaluate(input).getBlue()));
		
	}
}
