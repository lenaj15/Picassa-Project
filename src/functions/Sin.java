package functions;

import java.util.ArrayList;
import java.util.Map;

public class Sin extends Function{
	public Sin(ArrayList<Expression> list){
		super(list);
	}
	
	public boolean isThisKindOfThing(String type) {
		return (type.equals("sin"));
	}
	
	public RGBColor evaluate(Map <String,Expression> input) {
		return new RGBColor (Math.sin(myList.get(0).evaluate(input).getRed()), 
				Math.sin(myList.get(0).evaluate(input).getGreen()) ,
				Math.sin(myList.get(0).evaluate(input).getBlue()));
		
	}
}
