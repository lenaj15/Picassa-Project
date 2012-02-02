package functions;

import java.util.ArrayList;
import java.util.Map;


public class Neg extends Function{
	public Neg(ArrayList<Expression> list){
		super(list);
	}
	
	public boolean isThisKindOfThing(String type) {
		return (type.equals("neg") || type.equals("!"));
	}
	
	public RGBColor evaluate(Map <String,Expression> input) {
		
		return new RGBColor (myList.get(0).evaluate(input).getRed() , 
                -myList.get(0).evaluate(input).getGreen() ,
                -myList.get(0).evaluate(input).getBlue());
		
		
	}
}
