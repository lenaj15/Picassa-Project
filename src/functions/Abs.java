package functions;

import java.util.ArrayList;
import java.util.Map;

public class Abs extends Function{
	public Abs(ArrayList<Expression> list){
		super(list);
	}
	
	public boolean isThisKindOfThing(String type) {
		return (type.equals("abs"));
	}
	
	public RGBColor evaluate(Map <String,Expression> input) {
		return new RGBColor (Math.abs(myList.get(0).evaluate(input).getRed()), 
				Math.abs(myList.get(0).evaluate(input).getGreen()) ,
				Math.abs(myList.get(0).evaluate(input).getBlue()));
		
	}
}
