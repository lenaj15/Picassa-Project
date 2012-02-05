package functions;

import java.util.ArrayList;
import java.util.Map;


//Mul is a type of Function, which evaluates the ArrayList Expressions by taking their product
public class Mul extends Function {

	public Mul(ArrayList<Expression> list){
		super(list);
		myCommand = "mul";
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
		return (type.equals(myCommand) || type.equals("*"));
	}
	
	//Evaluates expression by multiplying the two inputs, for each color component
	public RGBColor evaluate(Map <String,Expression> input) {
		
		return new RGBColor (myList.get(0).evaluate(input).getRed() * myList.get(1).evaluate(input).getRed(), 
                            myList.get(0).evaluate(input).getGreen() * myList.get(1).evaluate(input).getGreen(),
                            myList.get(0).evaluate(input).getBlue() * myList.get(1).evaluate(input).getBlue());
	}

}
