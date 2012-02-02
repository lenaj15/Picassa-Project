package functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.util.ColorModel;
import model.util.PerlinNoise;

public class YCrCbtoRGB extends Function{
	
	public YCrCbtoRGB(ArrayList<Expression> list){
		super(list);
	}
	
	public boolean isThisKindOfThing(String type) {
		return (type.equals("YCrCbtoRGB") || type.equals("YCrCbToRGB"));
	}
	
	public RGBColor evaluate(Map <String,Expression> input) {
		
		return ColorModel.ycrcb2rgb(myList.get(0).evaluate(input));
		//return convertToRGB(myList.get(0).evaluate(input).getRed(), myList.get(1).evaluate(input).getRed(), myList.get(2).evaluate(input).getRed());
		
	}
	
	/*public RGBColor convertToRGB(double Y, double Cr, double Cb) {
		
		double R = Y + 1.402 * (Cr-128);
		double G = Y - 0.344 * (Cb-128) - 0.714 * (Cr-128);
		double B = Y + 1.772 * (Cb-128);
		
		RGBColor myColor = new RGBColor (R,G,B);
		myColor.clamp();
		return myColor;
	}*/
	
}
