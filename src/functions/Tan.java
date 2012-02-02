package functions;

import java.util.ArrayList;
import java.util.Map;

public class Tan extends Function{
	public Tan(ArrayList<Expression> list){
		super(list);
	}
	
	public boolean isThisKindOfThing(String type) {
		return (type.equals("tan"));
	}
	
	public RGBColor evaluate(Map <String,Expression> input) {
		return new RGBColor (Math.tan(myList.get(0).evaluate(input).getRed()), 
				Math.tan(myList.get(0).evaluate(input).getGreen()) ,
				Math.tan(myList.get(0).evaluate(input).getBlue()));
		
	}
}

