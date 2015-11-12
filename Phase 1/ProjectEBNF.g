grammar ProjectEBNF;

/* LEXICAL TOKENS/TERMINAL SYMBOLS */


TEXT : ('A'..'Z' | 'a'..'z' | '0'..'9' | ',' | '"' | ':' | '?' | '!' | '/' | '\u000C')*;
WS  :   ( ' ' | '\t'  | '\r' | '\n' ) {$channel=HIDDEN;} ;
DOCB	: '#BEGIN' | '#begin' ;
DOCE	: '#END' | '#end' ;
HEAD	: '^' ;
TITLEB	: '<' ;
TITLEE	: '>' ;
PARAB	: '{' ;
PARAE	: '}' ;
DEFB	: '$DEF' ;
DEFUSEE	: '$END' ;
EQSIGN	: '=' ;
USEB	: '$USE' ;
BOLD	: '**';
ITALICS	:  '*';
LISTITEMB 	: '+' ;	
LISTITEME	: ';' ;
NEWLINE		: '~' ;
LINKB		: '[' ;
LINKE		: ']' ;
AUDIO		: '@' ;
VIDEO		: '%' ;
ADDRESSB	: '(' ;
ADDRESSE	: ')' ;

/* SYNTAX RULES */

boldtext	:	BOLD TEXT+ BOLD;

italics		:	ITALICS TEXT+ ITALICS;

sentence 	:      	TEXT+ | boldtext+ | italics+ | listItem+ | audioLink+ | videoLink+ | link+;

address		:	ADDRESSB TEXT+ ADDRESSE;

title		:	TITLEB TEXT+ TITLEE;

header		:	HEAD title HEAD;

listItem 	:	LISTITEMB TEXT+ LISTITEME;

linkedPhrase	:	LINKB TEXT+ LINKE;

block 		:	PARAB sentence+ PARAE ;

defineVariable	:	DEFB sentence EQSIGN sentence DEFUSEE;

useVariable	:	USEB sentence DEFUSEE;
	 	
audioLink	: 	AUDIO address | AUDIO address NEWLINE;

videoLink	:	VIDEO address | VIDEO address NEWLINE;

link		:	linkedPhrase address | linkedPhrase address NEWLINE  ;

markdownLanguage
		:	DOCB header block+ DOCE | DOCB block+ DOCE;
	

	