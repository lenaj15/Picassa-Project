package functions;
import java.util.ArrayList;
import java.util.Map;


//Minus is a type of Function, which evaluates the ArrayList Expressions using subtraction
public class Minus extends Function {

	public Minus(ArrayList<Expression> list){
		super(list);
		myCommand = "minus";
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
		return (type.equals(myCommand) || type.equals("-"));
	}
	
	// Evaluates expression by subtracting the two inputs of each color component
	public RGBColor evaluate(Map <String,Expression> input) {
		
		return new RGBColor (myList.get(0).evaluate(input).getRed() - myList.get(1).evaluate(input).getRed(), 
                            myList.get(0).evaluate(input).getGreen() - myList.get(1).evaluate(input).getGreen(),
                            myList.get(0).evaluate(input).getBlue() - myList.get(1).evaluate(input).getBlue());
	}
}
