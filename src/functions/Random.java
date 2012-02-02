package functions;

import java.util.ArrayList;
import java.util.Map;

import model.ParserException;
import model.ParserException.Type;

public class Random extends Function{
	
	
	public Random(ArrayList<Expression> list){
		super(list);
		myList = null;
	}
	
	public boolean isThisKindOfThing(String type) {
		
		return (type.equals("random"));
	}
	
	public RGBColor evaluate(Map <String,Expression> input) {
		
		return new RGBColor (Math.random());
       
	}
}