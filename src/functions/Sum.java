package functions;

import java.util.ArrayList;
import java.util.Map;

/*Sum is a type of Function that combines 'n' number of colors by using their components 
 * in addition
*/
public class Sum extends Function{
	public Sum(ArrayList<Expression> list){
		super(list);
		myCommand = "sum";
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
		
		return (type.equals(myCommand));
	}
	
	//Evaluates expression by adding an 'n' number of inputs for each color component 
	public RGBColor evaluate(Map <String,Expression> input) {
		double red=0;
		double blue=0; 
		double green=0;
		for (int i=0; i<myList.size(); i++){
			red +=myList.get(i).evaluate(input).getRed();
			blue +=myList.get(i).evaluate(input).getBlue();
			green +=myList.get(i).evaluate(input).getGreen();
		}
		return new RGBColor (red,green, blue);
	}

}
