package functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.util.ColorModel;
import model.util.PerlinNoise;
/*YCrCbtoRGB is a type of Function that takes in a YUV color space type and converts it into 
 * RGB
*/
public class YCrCbtoRGB extends Function{
	
	public YCrCbtoRGB(ArrayList<Expression> list){
		super(list);
		myCommand = "YCrCbtoRGB";
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
		return (type.equals(myCommand) || type.equals("YCrCbToRGB"));
	}
	
	//Evaluates expression by converting YUV color space to RGB through the ColorModel class method
	public RGBColor evaluate(Map <String,Expression> input) {
		
		return ColorModel.ycrcb2rgb(myList.get(0).evaluate(input));		
	}
}
