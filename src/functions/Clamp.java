package functions;

import java.util.ArrayList;
import java.util.Map;

public class Clamp extends Function{
	
	
	public Clamp(ArrayList<Expression> list){
		super(list);
	}
	
	public boolean isThisKindOfThing(String type) {
		
		return (type.equals("clamp"));
	}
	
	public RGBColor evaluate(Map <String,Expression> input) {
		
		RGBColor newColor = new RGBColor (myList.get(0).evaluate(input));
	       newColor.clamp();
	       return newColor;
	}
}