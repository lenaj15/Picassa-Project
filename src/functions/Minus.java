package functions;
import java.util.ArrayList;
import java.util.Map;


public class Minus extends Function {

	public Minus(ArrayList<Expression> list){
		super(list);
	}
	
	public boolean isThisKindOfThing(String type) {
		return (type.equals("minus") || type.equals("-"));
	}
	
	@Override
	public RGBColor evaluate(Map <String,Expression> input) {
		
		return new RGBColor (myList.get(0).evaluate(input).getRed() - myList.get(1).evaluate(input).getRed(), 
                            myList.get(0).evaluate(input).getGreen() - myList.get(1).evaluate(input).getGreen(),
                            myList.get(0).evaluate(input).getBlue() - myList.get(1).evaluate(input).getBlue());
	}
}
