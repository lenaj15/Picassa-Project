package functions;

import java.util.ArrayList;
import java.util.Map;

/*Plus is a type of Function that combines two colors by using their components 
 * in addition
*/
public class Plus extends Function {

	public Plus(ArrayList<Expression> list){
		super(list);
		myCommand = "plus";
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
		
		return (type.equals(myCommand) || type.equals("+"));
	}
	
	//Evaluates expression by adding the two inputs 
	public RGBColor evaluate(Map <String,Expression> input) {
		
		return new RGBColor (myList.get(0).evaluate(input).getRed() + myList.get(1).evaluate(input).getRed(), 
                            myList.get(0).evaluate(input).getGreen() + myList.get(1).evaluate(input).getGreen(),
                            myList.get(0).evaluate(input).getBlue() + myList.get(1).evaluate(input).getBlue());
	}

}
