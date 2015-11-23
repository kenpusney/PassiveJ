grammar PassiveRecord;

model: (entity | relation | query | function | view | type)+;

entity : ENTITY name? record;

relation : RELATION name?;

query : QUERY name ;

function : FUNCTION name params (statement | expr);

view : VIEW name?;

record : LBRACE pair? (SEMI_COLONM pair)* RBRACE;

statement : expr SEMI_COLONM
          | LBRACE statement+ RBRACE;

pair : name COLONM hint constraint*;

constraint : UNIQUE
           | PRIMARY
           | NULLABLE
           | constraint_expr;

constraint_expr : DEFAULT LPAREN expr RPAREN
                | CHECK LPAREN expr RPAREN;

params : LPAREN param? (COMMA param)* RPAREN;

param : name | pair;

type : typedef | typealias;

typedef : TYPE name (record | SEMI_COLONM)
        | TYPE record;

typealias : TYPE alias=name origin=name;

hint : record | name;

expr : ID
     | QUERY query_expr
     | funcall_expr
     | literals;

funcall_expr: name (arguments | expr);

arguments : LPAREN expr? (COMMA expr)* RPAREN;

query_expr : selection pipe* (PIPE pipe)*;

selection : name ( DOT selection)*;

pipe : (projection | filtering | joining | ordering | grouping | aggregating | limiting);

projection : LPAREN projector (COMMA projector)* RPAREN;

projector : name
          | excluded_name
          | included_type;

excluded_name : TIELD name;
included_type : COLONM hint;

filtering : LSQUARE expr RSQUARE;

ordering : '//' selection;

grouping : '\\\\' selection;

aggregating : name | funcall_expr;

limiting : LBRACE padding=integer (COLONM paging=integer)? RBRACE;

joining : LPAREN selection (COMMA selection)+ ARROW expr RPAREN;

literals : number;

number : integer;

integer : INT;

name : ID;

ENTITY : 'entity';
VIEW: 'view';
QUERY: 'query';
FUNCTION: 'function';
RELATION: 'relation';
UNION: 'union';
UNIQUE: 'unique' | '!';
NULLABLE: 'nullable' | '?';
PRIMARY: 'primary';
DEFAULT: 'default';
CHECK: 'check';
TYPE: 'type';

SEMI_COLONM : ';';
COMMA : ',';
DOT : '.';
COLONM : ':';

TIELD : '~';

LBRACE : '{';
RBRACE : '}';
LPAREN : '(';
RPAREN : ')';
LSQUARE : '[';
RSQUARE : ']';

PIPE: '|';
ARROW : '->';

ID : [a-zA-Z]+;

INT : [0-9]+;

WS : [ \r\n\t]+ -> skip;