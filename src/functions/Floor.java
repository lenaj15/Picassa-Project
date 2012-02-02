package functions;

import java.util.ArrayList;
import java.util.Map;

public class Floor extends Function{
	public Floor(ArrayList<Expression> list){
		super(list);
	}
	
	public boolean isThisKindOfThing(String type) {
		return (type.equals("floor"));
	}
	
	public RGBColor evaluate(Map <String,Expression> input) {
		return new RGBColor (Math.floor(myList.get(0).evaluate(input).getRed()), 
				Math.floor(myList.get(0).evaluate(input).getGreen()) ,
				Math.floor(myList.get(0).evaluate(input).getBlue()));
		
	}
}
