package functions;

import java.util.ArrayList;
import java.util.Map;

/*ColorFunction is a type of Function, which evaluates the ArrayList Expressions by combining
 * the different color components from 3 different input expressions
*/
public class ColorFunction extends Function {
	public ColorFunction(ArrayList<Expression> list){
		super(list);
		myCommand = "color";
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
		return (type.equals(myCommand));
	}
	
	//Evaluates 3 input expressions and sets each as a color component for a new RGBColor
	public RGBColor evaluate(Map <String,Expression> input) {
		
		return new RGBColor (myList.get(0).evaluate(input).getRed() , 
                            myList.get(1).evaluate(input).getGreen(),
                            myList.get(2).evaluate(input).getBlue());
	}
}
