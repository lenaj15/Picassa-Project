package functions;

import java.util.ArrayList;
import java.util.Map;

public class Ceil extends Function{
	public Ceil(ArrayList<Expression> list){
		super(list);
	}
	
	public boolean isThisKindOfThing(String type) {
		return (type.equals("ceil"));
	}
	
	public RGBColor evaluate(Map <String,Expression> input) {
		return new RGBColor (Math.ceil(myList.get(0).evaluate(input).getRed()), 
				Math.ceil(myList.get(0).evaluate(input).getGreen()) ,
				Math.ceil(myList.get(0).evaluate(input).getBlue()));
		
	}
}
