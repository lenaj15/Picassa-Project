package functions;

import java.util.ArrayList;
import java.util.Map;

public class Wrap extends Function{
	
	
	public Wrap(ArrayList<Expression> list){
		super(list);
	}
	
	public boolean isThisKindOfThing(String type) {
		
		return (type.equals("wrap"));
	}
	
	public RGBColor evaluate(Map <String,Expression> input) {
		
		RGBColor newColor = new RGBColor (myList.get(0).evaluate(input));
       newColor.wrap();
       return newColor;
	}
}
