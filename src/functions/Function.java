package functions;

import java.util.ArrayList;
import java.util.Map;

public abstract class Function implements Expression{

	protected String myCommand;
    protected ArrayList <Expression> myList;
    protected Map<String, Expression> myMap;
    
	public Function(ArrayList<Expression> list){
		super();
		myList = list;
	}
	public Map<String, Expression> getMap(){
		return myMap;
	}
	 public String toString ()
	    {
	        StringBuffer result = new StringBuffer();
	       
	            result.append("(");
	            result.append(" " + myCommand + " ");
	            for (Expression e: myList){
	            	if (e!=null)
	            		result.append(e.toString());
	            }
	          
	            result.append(")");
	        
	        return result.toString();
	    }
	
	
}