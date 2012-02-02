package functions;

import java.util.ArrayList;
import java.util.Map;

import model.util.PerlinNoise;

public class PerlinColor extends Function {
	
	public PerlinColor(ArrayList<Expression> list){
		super(list);
	}
	
	public boolean isThisKindOfThing(String type) {
		return (type.equals("perlinColor"));
	}
	
	@Override
	public RGBColor evaluate(Map <String,Expression> input) {
		return PerlinNoise.colorNoise (myList.get(0).evaluate(input), myList.get(1).evaluate(input));
	}
}
