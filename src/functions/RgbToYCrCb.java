package functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.util.ColorModel;

/*RgbToYCrCb is a type of Function that takes in a RGB color and converts it into 
 * YUV color space
*/
public class RgbToYCrCb extends Function{
	
	public RgbToYCrCb(ArrayList<Expression> list){
		super(list);
		myCommand = "rgbToYCrCb";
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
		return (type.equals(myCommand));
	}
	
	//Evaluates expression by converting RGB into YUV color space through the ColorModel class method
	public RGBColor evaluate(Map <String,Expression> input) {
		return ColorModel.rgb2ycrcb(myList.get(0).evaluate(input));
	}
	
	
}
