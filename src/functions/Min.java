package functions;

import java.util.ArrayList;
import java.util.Map;

/*Min is a type of Function that returns the minimum color value
 * out of an arraylist of expressions
*/
public class Min extends Function {
	public Min(ArrayList<Expression> list){
		super(list);
		myCommand = "min";
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
		
		return (type.equals(myCommand));
	}
	
	//Evaluates expression by returning the minimum color expression
	public RGBColor evaluate(Map <String,Expression> input) {
		RGBColor minColor = null;
		for (int i=0; i<myList.size(); i++){
			RGBColor temp = myList.get(i).evaluate(input);
			if (minColor == null || minColor.compareTo(temp) > 0)
				minColor = temp;
		}
		return minColor;
	}
}
