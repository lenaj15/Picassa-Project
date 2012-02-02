package model;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import functions.Expression;
import functions.Parser;
import functions.Value;


/**
 * Evaluate an expression for each pixel in a image.
 * 
 * @author Robert C Duvall
 */
public class Model
{
    public static final double DOMAIN_MIN = -1;
    public static final double DOMAIN_MAX = 1;


    /**
     * Evaluate an expression for each point in the image.
     */
    public Pixmap evaluate (String input, Dimension size)
    {
        Pixmap result = new Pixmap(size);
        // create expression to evaluate just once
        Expression toEval = new Parser().makeExpression(input);
        
        // evaluate at each pixel
        for (int imageY = 0; imageY < size.height; imageY++)
        {
            double evalY = imageToDomainScale(imageY, size.height);
            for (int imageX = 0; imageX < size.width; imageX++)
            {
                
            	double evalX = imageToDomainScale(imageX, size.width);
            	
            	Map <String, Expression> mapping = new HashMap<String, Expression>();
            	mapping.put("x", new Value (evalX));
            	mapping.put("y", new Value (evalY));
            	result.setColor(imageX, imageY,toEval.evaluate(mapping).toJavaColor());
                //result.setColor(imageX, imageY,toEval.evaluate(evalX, evalY).toJavaColor());
            }
        }
        return result;
    }


    /**
     * Convert from image space to domain space.
     */
    protected double imageToDomainScale (int value, int bounds)
    {
        double range = DOMAIN_MAX - DOMAIN_MIN;
        return ((double)value / bounds) * range + DOMAIN_MIN;
    }
}
