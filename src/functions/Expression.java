package functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



import model.ParserException.Type;

/**
 * An Expression is an interface, which represents a mathematical expression as a tree.
 * 
 * In this format, there are 3 basic abstract methods that must be
 * implemented: evaluating the expression, checking to see what type of expression
 * it is, and a toString method
 */
public interface Expression
{
    
    public abstract RGBColor evaluate (Map <String,Expression> myMap);
	public abstract boolean isThisKindOfThing(String type);
	public abstract String toString ();
}
