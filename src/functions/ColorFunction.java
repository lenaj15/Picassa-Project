package functions;

import java.util.ArrayList;
import java.util.Map;


public class ColorFunction extends Function {
	public ColorFunction(ArrayList<Expression> list){
		super(list);
		
	}
	
	public boolean isThisKindOfThing(String type) {
		return (type.equals("color"));
	}
	
	public RGBColor evaluate(Map <String,Expression> input) {
		
		return new RGBColor (myList.get(0).evaluate(input).getRed() , 
                            myList.get(1).evaluate(input).getGreen(),
                            myList.get(2).evaluate(input).getBlue());
	}
}