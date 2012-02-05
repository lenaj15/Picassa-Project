package functions;

import java.util.ArrayList;
import java.util.Map;

import model.util.PerlinNoise;
/*PerlinColor is a type of Function that combines two colors by using their components 
 * to seed noise function in color
*/
public class PerlinColor extends Function {
	
	public PerlinColor(ArrayList<Expression> list){
		super(list);
		myCommand = "perlinColor";
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
		return (type.equals(myCommand));
	}
	
	//Evaluates expression by creating a noise function, through the PerlinNoise class
	public RGBColor evaluate(Map <String,Expression> input) {
		return PerlinNoise.colorNoise (myList.get(0).evaluate(input), myList.get(1).evaluate(input));
	}
}
