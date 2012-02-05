package functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.ParserException;
import model.ParserException.Type;

/**
 * A Variable is a type of function that can take any string and assign a value
 * to that variable using an internal Map 
 */
public class Variable extends Function{
	
	private Map <String, Expression> myMap;
	
	  /**
     * Create blank default variable 
     */
	public Variable(ArrayList<Expression> list, String command){
		super(list);
		myList = null;
		myCommand= command;
		myMap = null;
	}
	
	  /**
     * Create variable with the appropriate map
     */
	public Variable(ArrayList<Expression> list, Map <String, Expression> VariablesMap, String command){
		super(list);
		myList = null;
		myCommand= command;
		myMap = VariablesMap;
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
		return (myList==null);
	}
	
	// Returns the variables map
	public Map <String, Expression> getMap () {
		return myMap;
	}
	
	// Evaluates by returning the RGBColor expression stored in the map 
	//that is assigned to the variable name
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
