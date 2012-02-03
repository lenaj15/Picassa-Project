package functions;

import java.util.ArrayList;
import java.util.Map;

public class Let extends Function{
	
	public Let (ArrayList<Expression> exp){
		super (exp);
	}
	
	@Override
	
	//1st element in myList will be the variable 
	public RGBColor evaluate(Map<String, Expression> input) {
		input.putAll(((Variable) myList.get(0)).getMap()); 
		return myList.get(1).evaluate(input);
	}
	
	public boolean isThisKindOfThing(String type) {
	
		return (type.equals("let"));
	}

	
}
