package functions;

import java.util.ArrayList;
import java.util.Map;

//Abs is a type of Function, which evaluates the ArrayList with absolute values
public class Abs extends Function{
	
	public Abs(ArrayList<Expression> list){
		super(list);
	}

	// Checks if the command input matches the Expression type 
	public boolean isThisKindOfThing(String type) {
		return (type.equals("abs"));
	}
	
	//Evaluates expression by taking absolute value of each color component
	public RGBColor evaluate(Map <String,Expression> input) {
		return new RGBColor (Math.abs(myList.get(0).evaluate(input).getRed()), 
				Math.abs(myList.get(0).evaluate(input).getGreen()) ,
				Math.abs(myList.get(0).evaluate(input).getBlue()));
		
	}
}
