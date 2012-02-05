package functions;

import java.util.ArrayList;
import java.util.Map;

//Log is a type of Function, which evaluates the ArrayList Expressions by taking their log
public class Log extends Function{
	public Log(ArrayList<Expression> list){
		super(list);
		myCommand = "log";
	}
	
	// Checks if the command input matches the Expression type
	public boolean isThisKindOfThing(String type) {
		return (type.equals(myCommand));
	}
	
	// Evaluates expression by taking the log of each color component
	public RGBColor evaluate(Map <String,Expression> input) {
		return new RGBColor (Math.log(myList.get(0).evaluate(input).getRed()), 
				Math.log(myList.get(0).evaluate(input).getGreen()) ,
				Math.log(myList.get(0).evaluate(input).getBlue()));
		
	}
}
