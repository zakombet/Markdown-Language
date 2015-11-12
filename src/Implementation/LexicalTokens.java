
/** COSC 455 - Project #1 - Markdown Language Translation 
 *  
 * 
 *
 *
 *	Author - Zachary Kombet 
 */

 public class LexicalTokens
 {
 	final static String DOCB = "#BEGIN";
 	final static String DOCE = "#END";
 	final static String HEAD = "^";
 	final static String TITLEB = "<";
 	final static String TITLEE = ">";
 	final static String PARAB = "{";
 	final static String PARAE = "}";
 	final static String DEFB = "$DEF";
 	final static String DEFUSEE = "$END";
 	final static String EQSIGN = "="
 	final static String USEB = "$USE";
 	final static String BOLD = "**";
 	final static String ITALICS = "*";
 	final static String LISTITEMB = "+";
 	final static String LISTITEME = ";";
 	final static String NEWLINE = "~";
 	final static String LINKB = "[";
 	final static String LINKE = "]";
 	final static String AUDIO = "@";
 	final static String VIDEO = "%";
 	final static String ADDRESSB = "(";
 	final static String ADDRESSE = ")";

	private String info;

	/**
	 *
	 *
	 *
	 */
	public LexicalTokens(String info)
	{
		this.info = info;
	}

	/**
	 *
	 *
	 *
	 */
	public String getToken()
	{
		return info;
	}

 }