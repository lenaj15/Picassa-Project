package functions;

import java.util.ArrayList;
import java.util.Map;

import model.util.PerlinNoise;

/*PerlinBW is a type of Function that combines two colors by using their components 
 * to seed noise function in gray-scale
*/
public class PerlinBW extends Function {
	
	public PerlinBW(ArrayList<Expression> list){
		super(list);
		myCommand = "perlinBW";
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
		return (type.equals(myCommand));
	}
	
	//Evaluates expression by creating a noise function, through the PerlinNoise class
	public RGBColor evaluate(Map <String,Expression> input) {
		
		return PerlinNoise.greyNoise(myList.get(0).evaluate(input), myList.get(1).evaluate(input));	}
}