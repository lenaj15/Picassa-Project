package functions;

import java.util.ArrayList;
import java.util.Map;


public class Mod extends Function {

	public Mod(ArrayList<Expression> list){
		super(list);
	}
	
	
	public boolean isThisKindOfThing(String type) {
		return (type.equals("mod") || type.equals("%"));
	}
	
	public RGBColor evaluate(Map <String,Expression> input) {
		
		return new RGBColor (myList.get(0).evaluate(input).getRed() % myList.get(1).evaluate(input).getRed(), 
                            myList.get(0).evaluate(input).getGreen() % myList.get(1).evaluate(input).getGreen(),
                            myList.get(0).evaluate(input).getBlue() % myList.get(1).evaluate(input).getBlue());
	}

}
