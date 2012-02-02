package functions;

import java.util.ArrayList;
import java.util.Map;

public class Let implements Expression{

	private ArrayList<Expression> myList;
	private Map<String, Expression> myMap;
	//1st element in myList will be the variable 
	
	public Let (ArrayList<Expression> exp){
		myList = exp;
		myMap = null;
	}
	
	@Override
	public RGBColor evaluate(Map<String, Expression> input) {
		myMap = input;
		myMap.putAll(((Variable) myList.get(0)).myMap);
		return myList.get(1).evaluate(myMap);
	}
	
	public boolean isThisKindOfThing(String type) {
	
		return (type.equals("let"));
	}

	
}
