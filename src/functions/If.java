package functions;

import java.util.ArrayList;
import java.util.Map;

public class If extends Function{

	public If (ArrayList<Expression> exp){
		super (exp);
	}
	
	public RGBColor evaluate(Map<String, Expression> input) {
		RGBColor colors = myList.get(0).evaluate(input);
		if (((colors.getBlue()+ colors.getGreen()+ colors.getRed())/3) >0)
			return myList.get(1).evaluate(input);
	
		return myList.get(2).evaluate(myMap);
	}
	
	public boolean isThisKindOfThing(String type) {
	
		return (type.equals("if"));
	}

}
