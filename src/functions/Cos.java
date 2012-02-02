package functions;

import java.util.ArrayList;
import java.util.Map;

public class Cos extends Function{
	public Cos(ArrayList<Expression> list){
		super(list);
	}
	
	public boolean isThisKindOfThing(String type) {
		return (type.equals("cos"));
	}
	
	public RGBColor evaluate(Map <String,Expression> input) {
		return new RGBColor (Math.cos(myList.get(0).evaluate(input).getRed()), 
				Math.cos(myList.get(0).evaluate(input).getGreen()) ,
				Math.cos(myList.get(0).evaluate(input).getBlue()));
		
	}
}
