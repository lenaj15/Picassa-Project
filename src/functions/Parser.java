package functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.ParserException;
import model.ParserException.Type;



/**
 * Parses a string into an expression tree based on rules for arithmetic.
 * 
 * Due to the nature of the language being parsed, a recursive descent parser 
 * is used 
 *   http://en.wikipedia.org/wiki/Recursive_descent_parser
 *   
 * @author former student solution
 * @author Robert C. Duvall (added comments, exceptions, some functions)
 */
public class Parser
{
    // double is made up of an optional negative sign, followed by a sequence 
    // of one or more digits, optionally followed by a period, then possibly 
    // another sequence of digits
    private static final Pattern DOUBLE_REGEX =
        Pattern.compile("(\\-?[0-9]+(\\.[0-9]+)?)|(\\.[0-9]+)");
    // expression begins with a left paren followed by the command name, 
    // which is a sequence of alphabetic characters
    private static final Pattern EXPRESSION_BEGIN_REGEX =
      
    		 Pattern.compile("\\(([a-zA-Z]+)");
    		//  Pattern.compile("\\(([a-z]+)");
    private static final Pattern CHARACTER_REGEX =
    		 Pattern.compile("[a-zA-Z]+");
    		// Pattern.compile("[a-z]+");

    // different possible kinds of expressions
    private static enum ExpressionType
    {
        NUMBER, PAREN_EXPRESSION, CHARACTER
    }


    // state of the parser
    private int myCurrentPosition;
    private String myInput;


    /**
     * Converts given string into expression tree.
     * 
     * @param input expression given in the language to be parsed
     * @return expression tree representing the given formula
     */
    public Expression makeExpression (String input)
    {
        myInput = input;
        myCurrentPosition = 0;
     
        Expression result = parseExpression();
        skipWhiteSpace();
        if (notAtEndOfString())
        {
            throw new ParserException("Unexpected characters at end of the string: " +
                                      myInput.substring(myCurrentPosition),
                                      ParserException.Type.EXTRA_CHARACTERS);
        }
        return result;
    }


    private ExpressionType getExpressionType ()
    {
        skipWhiteSpace();
        if (isNumber())          return ExpressionType.NUMBER;
        if (isParenExpression()) return ExpressionType.PAREN_EXPRESSION;
        if (isCharacter()) 		 return ExpressionType.CHARACTER;
        else                     throw new ParserException("Unexpected Character " + currentCharacter());
    }


    private Expression parseExpression ()
    {
    	
        switch (getExpressionType())
        {
            case NUMBER:
                return parseNumber();
            case PAREN_EXPRESSION:
                return parseParenExpression();
            case CHARACTER:
            	return parseCharacter();	
            default:
                throw new ParserException("Unexpected expression type " +
                                          getExpressionType().toString());
        }
    }


    private boolean isNumber ()
    {
        Matcher doubleMatcher =
            DOUBLE_REGEX.matcher(myInput.substring(myCurrentPosition));
        return doubleMatcher.lookingAt();
    }


    private boolean isParenExpression ()
    {
        Matcher expMatcher =
            EXPRESSION_BEGIN_REGEX.matcher(myInput.substring(myCurrentPosition));
        return expMatcher.lookingAt();
    }

    private boolean isCharacter ()
    {
        Matcher charMatcher =
            CHARACTER_REGEX.matcher(myInput.substring(myCurrentPosition));
        return charMatcher.lookingAt();
    }
    
    
    private Expression parseNumber ()
    {
        Matcher doubleMatcher = DOUBLE_REGEX.matcher(myInput);
        doubleMatcher.find(myCurrentPosition);
        String numberMatch =
            myInput.substring(doubleMatcher.start(), doubleMatcher.end());
        myCurrentPosition = doubleMatcher.end();
        // this represents the color gray of the given intensity
        double value = Double.parseDouble(numberMatch);
        RGBColor gray = new RGBColor(value);
        return new Value(gray);
    }

    private Expression parseCharacter ()
    {
        Matcher charMatcher = CHARACTER_REGEX.matcher(myInput);
        charMatcher.find(myCurrentPosition);
        String charMatch =
            myInput.substring(charMatcher.start(), charMatcher.end());
        myCurrentPosition = charMatcher.end();
        ExpressionFactory factory = new ExpressionFactory();
        return factory.createExpression(charMatch, null);
     
    }

    
    private Expression parseParenExpression ()
    {
        Matcher expMatcher = EXPRESSION_BEGIN_REGEX.matcher(myInput);
        expMatcher.find(myCurrentPosition);
        String commandName = expMatcher.group(1);
       
        myCurrentPosition = expMatcher.end();
        String end = myInput.substring(myCurrentPosition);
        ArrayList <Expression> exp = new ArrayList<Expression>();
        
        Expression letExp = new Variable (null, null);
		if (commandName.equals("let")){
        	 letExp = parseLet(end);
        	 exp.add(letExp);
		}
       
        while (currentCharacter() != ')' && exp.size()<100){
        	Expression left = parseExpression();
        	exp.add(left);
        	skipWhiteSpace();
        }
        
        if (currentCharacter() == ')')
        {
            myCurrentPosition++;
         
            ExpressionFactory factory = new ExpressionFactory();
            return factory.createExpression(commandName, exp);
        }
        else
        {
            throw new ParserException("Expected close paren, instead found " +
                                      myInput.substring(myCurrentPosition));
        }
    }

    private Expression parseLet (String end)
    {
        Matcher charMatcher = CHARACTER_REGEX.matcher(myInput);
        charMatcher.find(myCurrentPosition);
        String charMatch =
            myInput.substring(charMatcher.start(), charMatcher.end());
        myCurrentPosition = charMatcher.end();
        skipWhiteSpace();
        Map <String, Expression> myMap = new HashMap<String, Expression>();
        myMap.put(charMatch, parseExpression());
       
        Variable toEval = new Variable (null, myMap,charMatch); 
        return toEval;
    }
    
    private void skipWhiteSpace ()
    {

    	while (notAtEndOfString() && Character.isWhitespace(currentCharacter()))
        {
            myCurrentPosition++;
        }
    }

    private char currentCharacter ()
    {
        return myInput.charAt(myCurrentPosition);
    }

    private boolean notAtEndOfString ()
    {
        return myCurrentPosition < myInput.length();
    }
}
