package functions;

import java.util.ArrayList;
import java.util.Map;

//Floor is a type of Function, which evaluates the ArrayList Expressions by
//returning the largest integer that is less than or equal to the given start number
public class Floor extends Function{
	public Floor(ArrayList<Expression> list){
		super(list);
		myCommand = "floor";
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
		return (type.equals(myCommand));
	}
	
	// Evaluates expression by taking the floor of each color component
public RGBColor evaluate(Map <String,Expression> input) {
		return new RGBColor (Math.floor(myList.get(0).evaluate(input).getRed()), 
				Math.floor(myList.get(0).evaluate(input).getGreen()) ,
				Math.floor(myList.get(0).evaluate(input).getBlue()));
		
	}
}
