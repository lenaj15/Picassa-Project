package functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



import model.ParserException.Type;

/**
 * An Expression represents a mathematical expression as a tree.
 * 
 * In this format, the internal nodes represent mathematical 
 * functions and the leaves represent constant values.
 *
 * @author former student solution
 * @author Robert C. Duvall (added comments, some code)
 */
public interface Expression
{
    
    public abstract RGBColor evaluate (Map <String,Expression> myMap);
	public abstract boolean isThisKindOfThing(String type);
	public abstract String toString ();
}
