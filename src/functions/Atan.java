package functions;

import java.util.ArrayList;
import java.util.Map;

public class Atan extends Function{
	public Atan(ArrayList<Expression> list){
		super(list);
	}
	
	public boolean isThisKindOfThing(String type) {
		return (type.equals("atan"));
	}
	
	public RGBColor evaluate(Map <String,Expression> input) {
		return new RGBColor (Math.atan(myList.get(0).evaluate(input).getRed()), 
				Math.atan(myList.get(0).evaluate(input).getGreen()) ,
				Math.atan(myList.get(0).evaluate(input).getBlue()));
		
	}
}
