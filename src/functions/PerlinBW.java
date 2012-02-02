package functions;

import java.util.ArrayList;
import java.util.Map;

import model.util.PerlinNoise;

public class PerlinBW extends Function {
	
	public PerlinBW(ArrayList<Expression> list){
		super(list);
	}
	
	public boolean isThisKindOfThing(String type) {
		return (type.equals("perlinBW"));
	}
	
	@Override
	public RGBColor evaluate(Map <String,Expression> input) {
		
		return PerlinNoise.greyNoise(myList.get(0).evaluate(input), myList.get(1).evaluate(input));	}
}