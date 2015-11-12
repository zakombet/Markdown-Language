package compiler;

/** COSC 455 - Project #1 - Markdown Language Translation 
 *  
 *  A character-by-character lexical analyzer that partitions the lexemes of the source file
 *  in our Markdown language into tokens. Must use the Lexical Analyzer interface. 
 *
 *	Author - Zachary Kombet 
 */


import java.io;  //Needed for input of file
import java.util; //Needed for scanner objecr 



public class LexicalAnalyzer implements LexicalInterface
{

    String nextCharacter = " ";
    String currentLine;
    int currentPosition = 0;
    LexicalTokens token;
    Scanner file;

 	/**
  	* Alternate Constructor 
  	*
  	*/
    public LexicalAnalyzer(String name) throws FileNotFounException
    {
    	file = new Scanner(new File(name));
        currentLine = file.nextLine();
        while(file.hasNextLine())
        {
        	currentLine = currentLine + file.nextLine();
        }
        nextCharacter = getCharacter();
    }

	/**
	 * This is the public method to be called when the Syntax Analyzer needs a new
	 * token to be parsed.
	 */
	public void getNextToken() throws CompilerException;
	{
		nextToken = " ";
		getCharacter();

		while(isSpace())
		{
			getCharacter();
		}

		while(!isSpace())
		{
			addCharacter();
			getCharacter();
		}

		if(lookupToken(nextToken))
		{
			return nextToken;
		}
		else
		{
			throw new CompilerException("LEXICAL ERROR: not a real token: " + nextToken + ".");
			System.exit(0);
		}
	}

	/**
	 * This is method gets the next character from the input and places it in
	 * the nextCharacter class variable.
	 *
	 * @return the character
	 */
	public void getCharacter();
	{
		char temp = currentLine.charAt(currentPosition);
		currentPosition++;
		return temp;
	}

	 /**
     * This method adds the current character the nextToken.
     */
	public void addCharacter();
	{
		nextToken = nextToken + nextCharacter;
	}

	/**
	 * This is method gets the next character from the input and places it in
	 * the nextCharacter class variable.
	 *
	 * @param c the current character
	 * @return true, if is space; otherwise false
	 */
	public boolean isSpace(String c)
	{
		return(c == " ");
	}

	/**
	 * This is method gets the next character from the input and places it in
	 * the nextCharacter class variable.
	 *
	 * @param c the current character
	 * @return true, if is space; otherwise false
	 */
	public boolean isTab(String c)
	{
		return(c == "\t");
	}


	/**
	 * This is method gets the next character from the input and places it in
	 * the nextCharacter class variable.
	 *
	 * @param c the current character
	 * @return true, if is space; otherwise false
	 */
	public boolean isNewLine(String c)
	{
		return(c == "\n");
	}
	/**
	 * This method checks to see if the current, possible token is legal in the
	 * defined grammar.
	 *
	 * @return true, if it is a legal token, otherwise false
	 */
	public boolean lookupToken(String nextToken);
	{
		return (nextToken.equalsIgnoreCase(LexicalTokens.DOCB))   	||
			   (nextToken.equalsIgnoreCase(LexicalTokens.DOCE))   	||
			   (nextToken.equalsIgnoreCase(LexicalTokens.HEAD))   	||
			   (nextToken.equalsIgnoreCase(LexicalTokens.TITLEB)) 	||
			   (nextToken.equalsIgnoreCase(LexicalTokens.TITLEE)) 	||  	
			   (nextToken.equalsIgnoreCase(LexicalTokens.PARAB))  	||
			   (nextToken.equalsIgnoreCase(LexicalTokens.PARAE))  	||
			   (nextToken.equalsIgnoreCase(LexicalTokens.DEFB))   	||
			   (nextToken.equalsIgnoreCase(LexicalTokens.DEFUSEE))	||
			   (nextToken.equalsIgnoreCase(LexicalTokens.EQSIGN)) 	||
			   (nextToken.equalsIgnoreCase(LexicalTokens.USEB))     ||
			   (nextToken.equalsIgnoreCase(LexicalTokens.BOLD))	    ||
			   (nextToken.equalsIgnoreCase(LexicalTokens.ITALICS))  ||
			   (nextToken.equalsIgnoreCase(LexicalTokens.LISTITEMB))||
			   (nextToken.equalsIgnoreCase(LexicalTokens.LISTITEME))||
			   (nextToken.equalsIgnoreCase(LexicalTokens.NEWLINE))  ||
			   (nextToken.equalsIgnoreCase(LexicalTokens.LINKB))    ||
			   (nextToken.equalsIgnoreCase(LexicalTokens.AUDIO))    ||
			   (nextToken.equalsIgnoreCase(LexicalTokens.VIDEO))    ||
			   (nextToken.equalsIgnoreCase(LexicalTokens.ADDRESSB)) ||
			   (nextToken.equalsIgnoreCase(LexicalTokens.ADDRESSE)) ;
	}

}