package functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.util.ColorModel;

public class RgbToYCrCb extends Function{
	
	public RgbToYCrCb(ArrayList<Expression> list){
		super(list);
	}
	
	public boolean isThisKindOfThing(String type) {
		return (type.equals("rgbToYCrCb"));
	}
	
	public RGBColor evaluate(Map <String,Expression> input) {
		return ColorModel.rgb2ycrcb(myList.get(0).evaluate(input));
	}
	
	
}
