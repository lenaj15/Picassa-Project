package functions;

import java.util.ArrayList;
import java.util.Map;

public class Log extends Function{
	public Log(ArrayList<Expression> list){
		super(list);
	}
	
	public boolean isThisKindOfThing(String type) {
		return (type.equals("log"));
	}
	
	public RGBColor evaluate(Map <String,Expression> input) {
		return new RGBColor (Math.log(myList.get(0).evaluate(input).getRed()), 
				Math.log(myList.get(0).evaluate(input).getGreen()) ,
				Math.log(myList.get(0).evaluate(input).getBlue()));
		
	}
}
