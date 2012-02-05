package functions;

import java.util.ArrayList;
import java.util.Map;

//Cos is a type of Function, which evaluates the ArrayList Expressions by taking their cosines
public class Cos extends Function{
	public Cos(ArrayList<Expression> list){
		super(list);
		myCommand = "cos";
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
		return (type.equals(myCommand));
	}
	
	// Evaluates expression by taking the cosine of each color component
	public RGBColor evaluate(Map <String,Expression> input) {
		return new RGBColor (Math.cos(myList.get(0).evaluate(input).getRed()), 
				Math.cos(myList.get(0).evaluate(input).getGreen()) ,
				Math.cos(myList.get(0).evaluate(input).getBlue()));
		
	}
}
