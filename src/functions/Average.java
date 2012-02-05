package functions;

import java.util.ArrayList;
import java.util.Map;

/*Average is a type of Function that combines 'n' number of colors by using their components 
 * in calculating the mean/average
*/
public class Average extends Function{
	public Average(ArrayList<Expression> list){
		super(list);
		myCommand = "average";
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
		
		return (type.equals(myCommand));
	}
	
	//Evaluates expression by taking the average of an 'n' number of inputs for each color component 
	public RGBColor evaluate(Map <String,Expression> input) {
		double red=0;
		double blue=0; 
		double green=0;
		int total= myList.size();
		for (int i=0; i<total; i++){
			red +=myList.get(i).evaluate(input).getRed();
			blue +=myList.get(i).evaluate(input).getBlue();
			green +=myList.get(i).evaluate(input).getGreen();
		}
		return new RGBColor (red/total,green/total, blue/total);
	}
}
