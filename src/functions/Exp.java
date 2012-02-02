package functions;

import java.util.ArrayList;
import java.util.Map;


public class Exp extends Function {

	public Exp(ArrayList<Expression> list){
		super(list);
	}
	
	public boolean isThisKindOfThing(String type) {
		return (type.equals("exp") || type.equals("^"));
	}
	
	public RGBColor evaluate(Map <String,Expression> input) {
		
		return new RGBColor (Math.pow(myList.get(0).evaluate(input).getRed(), myList.get(1).evaluate(input).getRed()), 
                           Math.pow(myList.get(0).evaluate(input).getGreen(), myList.get(1).evaluate(input).getGreen()),
                           Math.pow(myList.get(0).evaluate(input).getBlue(), myList.get(1).evaluate(input).getBlue()));
	}

}
