package functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.ParserException;
import model.ParserException.Type;

public class Variable extends Function{
	
	private Map <String, Expression> myMap;
	
	public Variable(ArrayList<Expression> list, String command){
		super(list);
		myList = null;
		myCommand= command;
		myMap = null;
	}
	
	public Variable(ArrayList<Expression> list, Map <String, Expression> VariablesMap, String command){
		super(list);
		myList = null;
		myCommand= command;
		myMap = VariablesMap;
	}
	
	public boolean isThisKindOfThing(String type) {
		return (myList==null);
		//return (type.equals("x") || type.equals("y"));
	}
	
	public Map <String, Expression> getMap () {
		return myMap;
	}
	
	public RGBColor evaluate(Map <String,Expression> input) {
		
		if (myMap == null)
			myMap = input;
		else
			myMap.putAll(input);
		Expression exp = myMap.get(myCommand);
		if (exp!= null)
			return new RGBColor (exp.evaluate(myMap));
        throw new ParserException("Unknown Command " + myCommand, Type.UNKNOWN_COMMAND);
	}

}
