package functions;

import java.util.ArrayList;
import java.util.Map;

/*Min is a type of Function that returns the maximum color value
 * out of an arraylist of expressions
*/
public class Max extends Function {
	public Max(ArrayList<Expression> list){
		super(list);
		myCommand = "max";
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
		
		return (type.equals(myCommand));
	}
	
	//Evaluates expression by returning the maximum color expression
	public RGBColor evaluate(Map <String,Expression> input) {
		RGBColor maxColor = null;
		for (int i=0; i<myList.size(); i++){
			RGBColor temp = myList.get(i).evaluate(input);
			if (maxColor == null || maxColor.compareTo(temp) < 0)
				maxColor = temp;
		}
		return maxColor;
	}
}
