package functions;

import java.util.Map;


public class Value implements Expression{

	private RGBColor myValue;
	
	public Value (RGBColor value){
		myValue = value;
	}
	
	public Value (double val){
		myValue = new RGBColor (val);
	}
	
	@Override
	public RGBColor evaluate(Map<String, Expression> myMap) {
		return myValue;
	}
	
	public boolean isThisKindOfThing(String type) {
	
		return (type.equals("value"));
	}
	
	 public String toString ()
	    {
	        StringBuffer result = new StringBuffer();
	        return result.append(myValue).toString(); 
	    }
	 public Map<String, Expression> getMap(){
			return null;
		}
	
}
