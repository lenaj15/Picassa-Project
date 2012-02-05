package functions;

import java.util.ArrayList;
import java.util.List;


import model.ParserException;
import model.ParserException.Type;

//This class contains a master list of expressions and creates the correct expression type
//based on the input command
public class ExpressionFactory {
	
	private ArrayList<Expression> myListofExpressions;
	
	//This method creates a master list of all expressions
	  private void createList ( ArrayList <Expression> myList, String myCommand)
	    {
	    	ArrayList<Expression> kindsofExpression= new ArrayList<Expression>();
	        kindsofExpression.add(new Let(myList));
	        kindsofExpression.add(new If (myList));
	        kindsofExpression.add(new Plus(myList));
	        kindsofExpression.add(new Minus(myList));
	        kindsofExpression.add(new Mul(myList));
	        kindsofExpression.add(new Div(myList));
	        kindsofExpression.add(new Mod(myList));
	        kindsofExpression.add(new Exp(myList));
	        kindsofExpression.add(new Neg(myList));
	        kindsofExpression.add(new ColorFunction(myList));
	        kindsofExpression.add(new Random(myList));
	        kindsofExpression.add(new Floor(myList));
	        kindsofExpression.add(new Ceil(myList));
	        kindsofExpression.add(new Abs(myList));
	        kindsofExpression.add(new Clamp(myList));
	        kindsofExpression.add(new Wrap(myList));
	        kindsofExpression.add(new Sin(myList));
	        kindsofExpression.add(new Cos(myList));
	        kindsofExpression.add(new Tan(myList));
	        kindsofExpression.add(new Atan(myList));
	        kindsofExpression.add(new Log(myList));
	        kindsofExpression.add(new RgbToYCrCb(myList));
	        kindsofExpression.add(new YCrCbtoRGB(myList));
	        kindsofExpression.add(new PerlinColor(myList));
	        kindsofExpression.add(new PerlinBW(myList));
	        kindsofExpression.add(new Sum(myList));
	        kindsofExpression.add(new Product (myList));
	        kindsofExpression.add(new Average(myList));
	        kindsofExpression.add(new Min (myList));
	        kindsofExpression.add(new Max(myList));
	        kindsofExpression.add(new Variable (myList, myCommand));
	        myListofExpressions = kindsofExpression;
	    }
	  
	  //This method determines/returns the type of expression a given myCommand input is
	  protected Expression createExpression(String myCommand, ArrayList <Expression> myList){
		
			createList(myList, myCommand);
		
		for (Expression type: myListofExpressions){
	        	if (type.isThisKindOfThing(myCommand)){
	        		
	        		return type;
	        	}
	        }

	    	throw new ParserException("Unknown Command " + myCommand, Type.UNKNOWN_COMMAND);
	  }

}
